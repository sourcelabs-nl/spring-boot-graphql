package nl.sourcelabs.graphql.application.types

data class Cancellation constructor(var orderId: String, var orderItemId: String, var reason: String, var quantityCancelled: Long)
