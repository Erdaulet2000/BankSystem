package com.sample.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sample.demo.DTO.UserDTO
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.io.Serializable
import java.math.BigInteger
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long,

        @Column(name = "username", unique = true)
        val username: String,

        @Column(name = "password")
        val password: String,

        @Column(name = "fullname")
        val fullname: String,

        @Column(name = "amount")
        val amount: BigInteger,

        @Column(name = "phoneNumber", unique = true)
        val phoneNumber: String,

        @JsonIgnore
        @OneToMany(mappedBy = "sender")
        @OnDelete(action = OnDeleteAction.CASCADE)
        val transferList: List<Transfer>,

        @JsonIgnore
        @OnDelete(action = OnDeleteAction.CASCADE)
        @OneToMany(mappedBy = "payer")
        val transactions: List<Transaction>
): Serializable {
}

fun User.toDTO() = UserDTO(
        id = id,
        username = username,
        password = password,
        fullname = fullname,
        amount = amount,
        phoneNumber = phoneNumber,
        transferList = transferList,
        transactions = transactions
)