package com.sample.demo.services

import com.sample.demo.DTO.TransferDTO
import com.sample.demo.exceptions.TransferNotFoundByIdException
import com.sample.demo.model.Transfer
import com.sample.demo.model.toDTO
import com.sample.demo.repository.TransferRepository
import com.sample.demo.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class TransferService(
        private val transferRepository: TransferRepository,
        private val userRepository: UserRepository
) {

    fun findAll() = transferRepository.findAll()

    @Transactional
    fun createTransfer(transferDTO: TransferDTO): TransferDTO {

        return transferRepository.save(
                Transfer(
                        id = 0,
                        sender = userRepository.getOne(transferDTO.senderId),
                        receiver = userRepository.getOne(transferDTO.receiverId),
                        amount = transferDTO.amount
                )
        ).toDTO()
    }

    @Transactional
    fun getAllBySenderIdAndReceiverId(receiverId: Long, senderId: Long) = transferRepository.findAllByReceiverIdAndSenderId(receiverId, senderId)

    @Transactional
    fun getAllBySenderId(senderId: Long) = transferRepository.findAllBySenderId(senderId)

    @Transactional
    fun getAllByReceiverId(receiverId: Long) = transferRepository.findAllByReceiverId(receiverId)


    @Transactional
    fun getAllTransfersByAmount(amount: Long, id: Long) = transferRepository.findAllByAmountAndSenderId(amount, id)

}