package com.sample.demo.controller

import com.sample.demo.DTO.TransferDTO
import com.sample.demo.services.TransferService
import com.sample.demo.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transfers")
class TransferController(
        private val transferService: TransferService,
        private val userService: UserService
) {
    @GetMapping("/all")
    fun getAllTransfers() = transferService.findAll()

    @PostMapping("/create")
    fun create(
            @RequestParam("amount", required = true) amount: Long,
            @RequestParam("senderId", required = true) senderId: Long,
            @RequestParam("receiverId", required = true) receiverId: Long
    ) = transferService.createTransfer(
                transferDTO = TransferDTO(
                        id = 0,
                        senderId = senderId,
                        receiverId = receiverId,
                        amount = amount
                )
        )

    @GetMapping("/get-all-by-senderId-receiverId")
    fun getAllBySenderIdAndReceiverId(
            @RequestParam("senderId", required = true) senderId: Long,
            @RequestParam("receiverId", required = true) receiverId: Long
    ) = transferService.getAllBySenderIdAndReceiverId(receiverId, senderId)

    @GetMapping("/get-all-by-senderId")
    fun getAllBySenderId(
            @RequestParam("senderId", required = true) senderId: Long
            ) = transferService.getAllBySenderId(senderId)

    @GetMapping("/get-all-by-receiverId")
    fun getAllByReceiverId(
            @RequestParam("receiverId", required = true) receiverId: Long
    ) = transferService.getAllByReceiverId(receiverId)

    @GetMapping("/get-all-by-amount")
    fun getAllTransfersByAmount(@RequestParam("amount", required = true) amount: Long,
                                @RequestParam("id", required = true) id: Long
    ) = transferService.getAllTransfersByAmount(amount, id)

}