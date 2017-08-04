package nl.sourcelabs.graphql.application.types

data class OrderItem constructor(var orderItemId: String, var productTitle: String, var quantityRequested: Long)