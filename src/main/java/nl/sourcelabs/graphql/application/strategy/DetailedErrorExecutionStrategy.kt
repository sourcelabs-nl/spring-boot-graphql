package nl.sourcelabs.graphql.application.strategy

import graphql.execution.ExecutionContext
import graphql.execution.SimpleExecutionStrategy
import graphql.schema.GraphQLFieldDefinition
import graphql.servlet.GenericGraphQLError
import nl.sourcelabs.graphql.application.DetailedErrorException
import java.lang.Exception

class DetailedErrorExecutionStrategy : SimpleExecutionStrategy() {
    override fun handleDataFetchingException(executionContext: ExecutionContext, fieldDef: GraphQLFieldDefinition?, argumentValues: MutableMap<String, Any>?, e: Exception?) {
        when (e) {
            is DetailedErrorException -> executionContext.addError(GenericGraphQLError(e.message))
            else -> super.handleDataFetchingException(executionContext, fieldDef, argumentValues, e)
        }
    }
}