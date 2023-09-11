package rmpw.model

import java.util.UUID

data class Location(
    val id: UUID,
    val longitude: Double,
    val latitude: Double,
    val address: String,
    val postcode: String
)
