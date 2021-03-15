package com.sample.demo.DTO

import com.sample.demo.model.Transaction
import com.sample.demo.model.Transfer
import java.math.BigInteger

class UserDTO(
        val id:Long,
        val username: String,
        val password: String,
        val fullname: String,
        val amount: BigInteger,
        val phoneNumber: String,
        val transferList: List<Transfer>,
        val transactions: List<Transaction>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserDTO

        if (id != other.id) return false
        if (username != other.username) return false
        if (password != other.password) return false
        if (fullname != other.fullname) return false
        if (amount != other.amount) return false
        if (phoneNumber != other.phoneNumber) return false
        if (transferList != other.transferList) return false
        if (transactions != other.transactions) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + username.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + fullname.hashCode()
        result = 31 * result + amount.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        result = 31 * result + transferList.hashCode()
        result = 31 * result + transactions.hashCode()
        return result
    }
}