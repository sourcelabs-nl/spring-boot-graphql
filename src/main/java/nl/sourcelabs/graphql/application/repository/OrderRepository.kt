package nl.sourcelabs.graphql.application.repository

import nl.sourcelabs.graphql.application.types.Order
import nl.sourcelabs.graphql.application.types.OrderItem
import org.springframework.stereotype.Repository

@Repository
class OrderRepository {

    // Some dummy data
    private val orderMap: Map<String, Order> = mapOf(
            "1" to Order(
                    orderId = "1",
                    orderReference = "123",
                    orderItems = listOf(
                            OrderItem("1", "iPhone 8", 2),
                            OrderItem("2", "Galaxy S9", 4),
                            OrderItem("3", "Nokia 3310", 100))
            )
    )

    fun getOrderById(orderId: String): Order? {
        return orderMap[orderId]
    }

    fun getOrderItemById(orderItemId: String?): OrderItem? {
        return orderMap.values.flatMap { it.orderItems.filter { it.orderItemId == orderItemId } }.firstOrNull()
    }
}