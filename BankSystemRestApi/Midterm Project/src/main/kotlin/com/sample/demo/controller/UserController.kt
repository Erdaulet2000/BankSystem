package com.sample.demo.controller

import com.sample.demo.DTO.UserDTO
import com.sample.demo.model.Transfer
import com.sample.demo.services.TransactionService
import com.sample.demo.services.TransferService
import com.sample.demo.services.UserService
import org.springframework.web.bind.annotation.*
import java.math.BigInteger

@RestController
@RequestMapping("/users")
class UserController(
        private val userService: UserService,
        private val transferService: TransferService,
        private val transactionService: TransactionService
) {

    @GetMapping("/all")
    fun getAllUsers() = userService.findAll()

    @PostMapping("/create")
    fun createUsers(
            @RequestParam("username", required = true) username: String,
            @RequestParam("password", required = true) password: String,
            @RequestParam("fullname", required = true) fullname: String,
            @RequestParam("amount", required = true) amount: BigInteger,
            @RequestParam("phoneNumber", required = true) phoneNumber: String
    ) {
        val transferList = transferService.findAll()
        val transactionList = transactionService.findAll()
        userService.addUser(
                userDTO = UserDTO(
                        id = 0,
                        username = username,
                        password = password,
                        fullname = fullname,
                        amount = amount,
                        phoneNumber = phoneNumber,
                        transferList = transferList,
                        transactions = transactionList
                )
        )
    }

    @GetMapping("/get-user-by-name")
    fun getUserByUsername(@RequestParam("username", required = true) username: String) = userService.getUserByUserName(username)

    @GetMapping("/get-user-by-phoneNumber")
    fun getUserByPhoneNumber(@RequestParam("phoneNumber", required = true) phoneNumber: String) = userService.getUserByPhoneNumber(phoneNumber)


    @GetMapping("/login")
    fun login(
            @RequestParam("username", required = true) username: String,
            @RequestParam("password", required = true) password: String
    ) = userService.login(username, password)


    @DeleteMapping("/delete-by-id")
    fun deleteUserById(
            @RequestParam("id", required = true) id:Long
    )  = userService.deleteUserById(id)
}