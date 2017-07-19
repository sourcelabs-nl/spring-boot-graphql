# GraphQL application

This is a Spring Boot based GraphQL application written in Kotlin.

Structure:

- Schema is defined in src/main/resources/application.graphqls
- Resolvers are in the nl/sourcelabs/graphql/application/resolvers package. This is the most interesting part because it shows the entry point and the cancellations retrieval.

Running:

- mvn spring-boot:run
- You should be able to access GraphiQL using your browser: http://localhost:8080

Sample request:

```graphql
{
  order(orderId: "1") {
    orderReference
    orderItems {
      productTitle
      cancellations {
        reason
      }
    }
  }
}
```