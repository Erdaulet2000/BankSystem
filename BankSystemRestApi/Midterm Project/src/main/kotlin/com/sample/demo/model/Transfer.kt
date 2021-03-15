package com.sample.demo.model

import com.sample.demo.DTO.TransferDTO
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "transfer")
class Transfer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column()
        val id: Long,

        @ManyToOne
        val sender: User,

        @ManyToOne
        val receiver: User,

        @Column()
        val amount: Long,
)

fun Transfer.toDTO() = TransferDTO(
        id = id,
        senderId = sender.id,
        receiverId = receiver.id,
        amount = amount
)