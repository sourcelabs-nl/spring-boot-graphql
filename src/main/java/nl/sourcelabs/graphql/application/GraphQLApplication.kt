package nl.sourcelabs.graphql.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GraphQLApplication {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(GraphQLApplication::class.java, *args)
        }
    }
}
