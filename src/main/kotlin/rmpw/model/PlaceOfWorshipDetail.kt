package rmpw.model

import java.util.*

data class PlaceOfWorshipDetail(
    val id: UUID,
    val name: String,
    val type: POWType,
    val location: Location,
    val website: String?
)
