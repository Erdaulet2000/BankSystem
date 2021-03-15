package com.sample.demo.services

import com.sample.demo.DTO.TransactionDTO
import com.sample.demo.model.Transaction
import com.sample.demo.model.TransactionType
import com.sample.demo.model.toDTO
import com.sample.demo.repository.TransactionRepository
import com.sample.demo.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionService(
        private val transactionRepository: TransactionRepository,
        private val userRepository: UserRepository
) {

    fun findAll() = transactionRepository.findAll()

    @Transactional
    fun createTransaction(transactionDTO: TransactionDTO): TransactionDTO {
        return transactionRepository.save(
                Transaction(
                        id = 0,
                        payer = userRepository.getOne(transactionDTO.payerId),
                        amount = transactionDTO.amount,
                        commission = transactionDTO.commission,
                        transactionType = transactionDTO.type,
                        value = transactionDTO.value
                )
        ).toDTO()
    }

    @Transactional
    fun getAllByPayerId(payerId: Long) = transactionRepository.findAllByPayerId(payerId)

    @Transactional
    fun getAllByTransactionTypeAndPayerId(type: TransactionType, payerId: Long) = transactionRepository.findAllByTransactionTypeAndPayerId(type, payerId)

    @Transactional
    fun getAllByAmountAndPayerId(amount: Long, payerId: Long) = transactionRepository.findAllByAmountAndPayerId(amount, payerId)
}