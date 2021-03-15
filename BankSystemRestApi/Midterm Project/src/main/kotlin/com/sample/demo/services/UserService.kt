package com.sample.demo.services

import com.sample.demo.DTO.UserDTO
import com.sample.demo.exceptions.UserAlreadyExistsException
import com.sample.demo.exceptions.UserNotFoundByPhoneNumberException
import com.sample.demo.exceptions.UserNotFoundByUsernameAndPasswordException
import com.sample.demo.exceptions.UserNotFoundByUsernameException
import com.sample.demo.model.User
import com.sample.demo.model.toDTO
import com.sample.demo.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun findAll() = userRepository.findAll().map {
        it.toDTO()
    }

    @Transactional
    fun getUserByUserName(username: String) = (userRepository.findUserByUsername(username)
            ?: throw UserNotFoundByUsernameException(username)).toDTO()


    @Transactional
    fun addUser(userDTO: UserDTO): UserDTO {
        val user = userRepository.findUserByUsername(username = userDTO.username)

        if (user != null) throw UserAlreadyExistsException(userDTO.username)

        return userRepository.save(
                User(
                        id = 0,
                        username = userDTO.username,
                        password = userDTO.password,
                        fullname = userDTO.fullname,
                        amount = userDTO.amount,
                        phoneNumber = userDTO.phoneNumber,
                        transferList = userDTO.transferList,
                        transactions = userDTO.transactions
                )
        ).toDTO()
    }

    @Transactional
    fun getUserByPhoneNumber(phoneNumber: String) = (userRepository.findUserByPhoneNumber(phoneNumber)
            ?: throw UserNotFoundByPhoneNumberException(phoneNumber)).toDTO()

    @Transactional
    fun login(username: String, password: String) = (userRepository.findUserByUsernameAndPassword(username, password)
            ?: throw UserNotFoundByUsernameAndPasswordException(username, password)).toDTO()

    @Transactional
    fun deleteUserById(id: Long) = userRepository.deleteById(id)

}