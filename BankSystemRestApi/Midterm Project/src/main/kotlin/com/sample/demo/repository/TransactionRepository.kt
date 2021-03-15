package com.sample.demo.repository

import com.sample.demo.model.Transaction
import com.sample.demo.model.TransactionType
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository:JpaRepository<Transaction, Long> {
    fun findAllByPayerId(id: Long): List<Transaction>

    fun findAllByTransactionTypeAndPayerId(transactionType: TransactionType, payerId: Long): List<Transaction>

    fun findAllByAmountAndPayerId(amount: Long, payerId: Long): List<Transaction>
}