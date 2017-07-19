package nl.sourcelabs.graphql.application

import com.coxautodev.graphql.tools.SchemaParserDictionary
import nl.sourcelabs.graphql.application.types.Cancellation
import nl.sourcelabs.graphql.application.types.Order
import nl.sourcelabs.graphql.application.types.OrderItem
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class GraphQLApplication {

    @Bean
    open fun schemaParserDictionary(): SchemaParserDictionary {
        return SchemaParserDictionary().add(dictionary = listOf(Order::class.java, OrderItem::class.java, Cancellation::class.java))
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(GraphQLApplication::class.java, *args)
        }
    }
}
