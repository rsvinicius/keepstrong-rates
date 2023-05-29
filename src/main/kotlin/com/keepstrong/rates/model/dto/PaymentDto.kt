package com.keepstrong.rates.model.dto

import com.keepstrong.rates.model.PaymentStatus
import java.math.BigDecimal

data class PaymentDto(
        val id: Long = -1,
        val value: BigDecimal = BigDecimal.valueOf(-1),
        val name: String = "",
        val cardNumber: String = "",
        val expirationDate: String = "",
        val cardCode: String = "",
        var status: PaymentStatus? = null,
        val orderId: Long = -1,
        val paymentMethodId: Long = -1
)