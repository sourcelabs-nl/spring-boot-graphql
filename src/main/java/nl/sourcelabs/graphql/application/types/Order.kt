package nl.sourcelabs.graphql.application.types

data class Order constructor(val orderId: String? = null, val orderReference: String? = null, val dateTimePlaced: String? = null, val totalPrice: String? = null, val orderItems: List<OrderItem>)