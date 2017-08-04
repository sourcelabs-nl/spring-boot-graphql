package nl.sourcelabs.graphql.application.types

import graphql.annotations.GraphQLName

@GraphQLName("OrderItem")
data class OrderItem constructor(var orderItemId: String, var productTitle: String, var quantityRequested: Long)