package nl.sourcelabs.graphql.application.repository

import nl.sourcelabs.graphql.application.types.Cancellation
import org.springframework.stereotype.Repository

@Repository
class CancellationRepository {

    private val cancellations: List<Cancellation> = listOf(Cancellation(orderId = "1", reason = "FRAUD", quantityCancelled = 1, orderItemId = "1"))

    fun getCancellationsByOrderItemId(orderItemId: String): List<Cancellation> {
        return cancellations.filter { it.orderItemId == orderItemId }
    }
}