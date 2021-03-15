package com.sample.demo.repository

import com.sample.demo.model.Transfer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TransferRepository:JpaRepository<Transfer, Long> {
    fun findAllByAmountAndSenderId(amount: Long, id: Long): List<Transfer>
    fun findAllBySenderId(id: Long): List<Transfer>
    fun findAllByReceiverId(id: Long): List<Transfer>
    fun findAllByReceiverIdAndSenderId(receiverId: Long, senderIde: Long): List<Transfer>
}