package nl.sourcelabs.graphql.application.resolvers

import com.coxautodev.graphql.tools.GraphQLResolver
import nl.sourcelabs.graphql.application.DetailedErrorException
import nl.sourcelabs.graphql.application.repository.CancellationRepository
import nl.sourcelabs.graphql.application.types.Cancellation
import nl.sourcelabs.graphql.application.types.OrderItem
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger

/**
 * A GraphQLResolver resolves child elements in a specific context. In this case the child cancellations of an orderItem are resolved.
 */
@Component
class OrderItemResolver(private val cancellationRepository: CancellationRepository) : GraphQLResolver<OrderItem> {

    private val atomicInteger = AtomicInteger(0)

    fun cancellations(orderItem: OrderItem): List<Cancellation> {
        if (atomicInteger.incrementAndGet() % 2 == 0) throw DetailedErrorException("Retrieving cancellations for orderItemId: ${orderItem.orderItemId} failed.")
        return cancellationRepository.getCancellationsByOrderItemId(orderItem.orderItemId)
    }

}
