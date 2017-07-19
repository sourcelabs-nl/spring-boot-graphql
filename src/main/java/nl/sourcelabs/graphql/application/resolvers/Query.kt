package nl.sourcelabs.graphql.application.resolvers

import com.coxautodev.graphql.tools.GraphQLRootResolver
import nl.sourcelabs.graphql.application.repository.CancellationRepository
import nl.sourcelabs.graphql.application.repository.OrderRepository
import nl.sourcelabs.graphql.application.types.Cancellation
import nl.sourcelabs.graphql.application.types.Order
import nl.sourcelabs.graphql.application.types.OrderItem
import org.springframework.stereotype.Component

/**
 * This is the Root type, entry point for building new queries.
 */
@Component
class Query(var orderRepository: OrderRepository, var cancellationRepository: CancellationRepository) : GraphQLRootResolver {

    fun order(orderId: String?): Order? {
        return orderId?.let { return orderRepository.getOrderById(orderId) }
    }

    fun orderItem(orderItemId: String?): OrderItem? {
        return orderRepository.getOrderItemById(orderItemId)
    }

    fun cancellations(orderItemId: String): List<Cancellation>? {
        return cancellationRepository.getCancellationsByOrderItemId(orderItemId)
    }
}
