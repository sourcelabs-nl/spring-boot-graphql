package nl.sourcelabs.graphql.application

import graphql.execution.ExecutionStrategy
import nl.sourcelabs.graphql.application.strategy.DetailedErrorExecutionStrategy
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class GraphQLApplication {

    @Bean
    fun executionStrategies(): Map<String, ExecutionStrategy> {
        return mapOf("queryExecutionStrategy" to DetailedErrorExecutionStrategy())
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(GraphQLApplication::class.java, *args)
        }
    }
}
