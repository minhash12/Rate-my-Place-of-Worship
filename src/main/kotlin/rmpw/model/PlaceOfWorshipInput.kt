package rmpw.model

import java.util.*

data class PlaceOfWorshipInput(
    val name: String,
    val type: POWType,
    val location: LocationInput,
    val website: String?
)
