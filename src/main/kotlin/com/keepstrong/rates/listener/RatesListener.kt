package com.keepstrong.rates.listener

import com.keepstrong.rates.model.dto.PaymentDto
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RatesListener {
    @RabbitListener(queues = ["payment.rates-details"])
    fun receiveMessage(paymentDto: PaymentDto) {
        println("It's necessary to create an evaluation record for the order:\n" +
                "Payment Id: ${paymentDto.id}\n" +
                "Client Name: ${paymentDto.name}\n" +
                "Value R$: ${paymentDto.value}\n" +
                "Status: ${paymentDto.status}\n")
    }
}