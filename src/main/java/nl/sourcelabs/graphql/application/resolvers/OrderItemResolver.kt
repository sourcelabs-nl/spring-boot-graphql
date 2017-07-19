package nl.sourcelabs.graphql.application.resolvers

import com.coxautodev.graphql.tools.GraphQLResolver
import nl.sourcelabs.graphql.application.repository.CancellationRepository
import nl.sourcelabs.graphql.application.types.Cancellation
import nl.sourcelabs.graphql.application.types.OrderItem
import org.springframework.stereotype.Component

/**
 * A GraphQLResolver resolves child elements in a specific context. In this case the child cancellations of an orderItem are resolved.
 */
@Component
class OrderItemResolver(private val cancellationRepository: CancellationRepository) : GraphQLResolver<OrderItem> {

    fun cancellations(orderItem: OrderItem): List<Cancellation> {
        return cancellationRepository.getCancellationsByOrderItemId(orderItem.orderItemId)
    }
}
