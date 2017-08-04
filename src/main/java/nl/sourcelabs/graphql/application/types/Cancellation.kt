package nl.sourcelabs.graphql.application.types

import graphql.annotations.GraphQLName

@GraphQLName("Cancellation")
data class Cancellation constructor(var orderId: String, var orderItemId: String, var reason: String, var quantityCancelled: Long)
