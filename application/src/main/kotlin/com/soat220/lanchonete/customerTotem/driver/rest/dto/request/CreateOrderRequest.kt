package com.soat220.lanchonete.customerTotem.driver.rest.dto.request

import com.soat220.lanchonete.customerTotem.usecase.dto.CreateOrder

class CreateOrderRequest(
    val customer: CreateCustomerRequest?,
    val orderItems: List<CreateOrderItemRequest>,
    val notes: String?
) {
    fun toDomain() = CreateOrder(
        customer = customer?.toDomain(),
        orderItems = orderItems.map { it.toDomain() },
        notes = notes
    )
}