package com.sample.demo.controller

import com.sample.demo.DTO.TransactionDTO
import com.sample.demo.model.TransactionType
import com.sample.demo.services.TransactionService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/transactions")
class TransactionController(
        private val transactionService: TransactionService
) {

    @GetMapping("/all")
    fun getAllTransactions() = transactionService.findAll()

    @PostMapping("/create")
    fun create(
            @RequestParam("payerId", required = true) payerId: Long,
            @RequestParam("amount", required = true) amount: Long,
            @RequestParam("commission", required = true) commission: Long,
            @RequestParam("type", required = true) type: TransactionType,
            @RequestParam("value", required = true) value: String
    ) = transactionService.createTransaction(
            transactionDTO = TransactionDTO(
                    id = 0,
                    payerId = payerId,
                    amount = amount,
                    commission = commission,
                    type = type,
                    value = value
            )
    )

    @GetMapping("/get-all-payerId")
    fun getAllByPayerId(
            @RequestParam("payerId", required = true) payerId: Long
    ) = transactionService.getAllByPayerId(payerId)

    @GetMapping("/get-all-by-type-payerId")
    fun getAllByTransactionTypeAndPayerId(
            @RequestParam("type", required = true) type: TransactionType,
            @RequestParam("payerId", required = true) payerId: Long
    ) = transactionService.getAllByTransactionTypeAndPayerId(type, payerId)

    @GetMapping("/get-all-by-amount-payerId")
    fun getAllByAmountAndPayerId(
            @RequestParam("amount", required = true) amount: Long,
            @RequestParam("payerId", required = true) payerId: Long
    ) = transactionService.getAllByAmountAndPayerId(amount, payerId)

}