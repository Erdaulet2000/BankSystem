package com.sample.demo.exceptions

class UserNotFoundByUsernameException(username: String): RuntimeException("No such $username username")
class UserNotFoundByPhoneNumberException(username: String): RuntimeException("No such $username username")
class UserNotFoundByUsernameAndPasswordException(username: String, password: String): RuntimeException("No such $username username and $password password")
class UserAlreadyExistsException(username: String): RuntimeException("Username $username is already exist")
class TransferNotFoundByIdException(id: Long): RuntimeException("No such $id transfer id")