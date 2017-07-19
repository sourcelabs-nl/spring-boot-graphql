# GraphQL application

This is a Spring Boot based GraphQL application written in Kotlin.

Structure:

- Schema is defined in src/main/resources/application.graphqls
- Resolvers are in the src/main/java/nl/sourcelabs/graphql/application/resolvers package. This is the most interesting part because it shows the entry point and the parent-child retrieval.

Running:

- mvn spring-boot:run
- You should be able to access GraphiQL using your browser: http://localhost:8080

Schema definition:

```graphql schema

type Query {
    order(orderId: String!): Order @doc(d: "Finding orders by its identifiers or customer number. orderId is the identifier and unique. orderReference is an externally provided order identifier"),
    orderItem(orderItemId: String!):OrderItem @doc(d: "Look for orderItems based on  orderItemId")
    cancellations(orderItemId: String!): [Cancellation] @doc(d: "Find the cancellations for an orderItem")
}

type Order @doc(d: "A customer order") {
    orderId: String! @doc(d: "The id of the order"),
    orderReference: String @doc(d: "The external identifier of the order"),
    totalPrice: String @doc(d: "Order total amount"),
    dateTimePlaced: String @doc(d: "The dateTime placed")
    orderItems: [OrderItem] @doc(d: "The order items/lines")
}

type OrderItem @doc(d: "An item/line from the Order") {
    orderItemId: String! @doc(d: "The id of the  orderItem"),
    productTitle: String @doc(d: "Product title / description"),
    quantityRequested: Long! @doc(d: "The quantity requested by the customer")
    cancellations: [Cancellation] @doc(d: "The cancellation message for item/line")
}

type Cancellation  @doc(d: "Defines the cancellations on an orderItem") {
    orderId: String! @doc(d: "The id of the order"),
    orderItemId: String! @doc(d: "The id of the  orderItem"),
    quantityCancelled: Long! @doc(d: "Quantity that has been cancelled"),
    reason: String @doc(d: "Cancellation reason")
}
```

Sample request for GraphiQL fetching an order including items additionally fetching the related cancellations per order item:

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