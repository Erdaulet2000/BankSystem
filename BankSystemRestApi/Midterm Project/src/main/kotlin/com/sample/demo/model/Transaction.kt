package com.sample.demo.model

import com.sample.demo.DTO.TransactionDTO
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "transaction")
class Transaction(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column()
        val id: Long,

        @ManyToOne
        val payer: User,

        @Column()
        val amount: Long,

        @Column()
        val commission: Long,

        @Column()
        @Enumerated(EnumType.STRING)
        val transactionType: TransactionType,

        @Column()
        val value: String
)

fun Transaction.toDTO() = TransactionDTO(
        id = id,
        payerId = payer.id,
        amount = amount,
        commission = commission,
        type = transactionType,
        value = value
)