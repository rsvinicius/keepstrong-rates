package com.keepstrong.rates.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AMQPConfig {
    @Bean
    fun ratesDetailsQueue(): Queue {
        return QueueBuilder
                .nonDurable("payment.rates-details")
                .deadLetterExchange("payment.dlx")
                .build()
    }

    @Bean
    fun deadLetterRatesDetailsQueue(): Queue {
        return Queue("payment.rates-details-dlq", false)
    }

    @Bean
    fun fanoutExchange(): FanoutExchange {
        return FanoutExchange("payment.ex")
    }

    @Bean
    fun deadLetterExchange(): FanoutExchange {
        return FanoutExchange("payment.dlx")
    }

    @Bean
    fun paymentRatesBinding(): Binding {
        return BindingBuilder.bind(ratesDetailsQueue())
                .to(fanoutExchange())
    }

    @Bean
    fun paymentRatesDlxBinding(): Binding {
        return BindingBuilder.bind(deadLetterRatesDetailsQueue())
                .to(deadLetterExchange())
    }

    @Bean
    fun createRabbitAdmin(connectionFactory: ConnectionFactory): RabbitAdmin {
        return RabbitAdmin(connectionFactory)
    }

    @Bean
    fun initializeAdmin(rabbitAdmin: RabbitAdmin): ApplicationListener<ApplicationReadyEvent> {
        return ApplicationListener { rabbitAdmin.initialize() }
    }

    @Bean
    fun messageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun rabbitTemplate(
            connectionFactory: ConnectionFactory,
            messageConverter: Jackson2JsonMessageConverter
    ): RabbitTemplate {
        return RabbitTemplate(connectionFactory).apply {
            this.messageConverter = messageConverter
        }
    }
}