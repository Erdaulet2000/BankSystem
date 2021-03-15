package com.sample.demo.DTO

import com.sample.demo.model.TransactionType

class TransactionDTO(
        val id: Long,
        val payerId: Long,
        val amount: Long,
        val commission: Long,
        val type: TransactionType,
        val value: String

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionDTO

        if (payerId != other.payerId) return false
        if (amount != other.amount) return false
        if (commission != other.commission) return false
        if (type != other.type) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = payerId.hashCode()
        result = 31 * result + amount.hashCode()
        result = 31 * result + commission.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }
}