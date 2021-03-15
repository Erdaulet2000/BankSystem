package com.sample.demo.repository

import com.sample.demo.DTO.UserDTO
import com.sample.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User, Long> {
    fun findUserByUsername(username: String): User?
    fun findUserByPhoneNumber(phoneNumber: String): User?
    fun findUserByUsernameAndPassword(username: String, password:String): User?
}