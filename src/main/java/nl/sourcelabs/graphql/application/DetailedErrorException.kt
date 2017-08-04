package nl.sourcelabs.graphql.application

class DetailedErrorException(override val message: String) : RuntimeException(message)