package rmpw.model

data class PlaceOfWorshipSearch(
    val type: POWType,
    val location: String,
    val distance: Int
)
