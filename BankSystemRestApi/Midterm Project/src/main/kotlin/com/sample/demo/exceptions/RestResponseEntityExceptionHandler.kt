package com.sample.demo.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun handle(e: Exception): ResponseEntity<String> = when(e){
        is UserNotFoundByUsernameException -> ResponseEntity(e.localizedMessage, HttpStatus.BAD_REQUEST)
        is UserNotFoundByPhoneNumberException -> ResponseEntity(e.localizedMessage, HttpStatus.NOT_FOUND)
        is UserNotFoundByUsernameAndPasswordException -> ResponseEntity(e.localizedMessage, HttpStatus.NOT_FOUND)
        is UserAlreadyExistsException -> ResponseEntity(e.localizedMessage, HttpStatus.BAD_REQUEST)
        is TransferNotFoundByIdException -> ResponseEntity(e.localizedMessage, HttpStatus.BAD_REQUEST)
        else -> ResponseEntity(e.localizedMessage, HttpStatus.UNAUTHORIZED)
    }

}