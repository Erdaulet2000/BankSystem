package com.sample.demo.DTO

class TransferDTO(
        val id: Long,
        val amount:Long,
        val senderId: Long,
        val receiverId: Long
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransferDTO

        if (amount != other.amount) return false
        if (senderId != other.senderId) return false
        if (receiverId != other.receiverId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = amount.hashCode()
        result = 31 * result + senderId.hashCode()
        result = 31 * result + receiverId.hashCode()
        return result
    }
}