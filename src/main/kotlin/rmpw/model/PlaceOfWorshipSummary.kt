package rmpw.model

import java.util.UUID

data class PlaceOfWorshipSummary(
    val id: UUID,
    val name: String,
    val type: POWType,
    val location: Location

)
