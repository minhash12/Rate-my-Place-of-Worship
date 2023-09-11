package rmpw.model

import java.util.UUID

data class PlaceOfWorshipComments(
    val id: UUID,
    val comments: List<String>
)
