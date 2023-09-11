package rmpw.model

data class LocationInput(
    val longitude: Double,
    val latitude: Double,
    val address: String,
    val postcode: String
)
