package rmpw.model

import java.math.BigDecimal
import java.util.*

data class PlaceOfWorshipScore(
    val id: UUID,
    val name: String,
    val type: POWType,
    val welcomingAtmosphere: BigDecimal,
    val facilities: BigDecimal,
    val toilets: BigDecimal,
    val carParking: BigDecimal,
    val publicTransport: BigDecimal,
    val cycle: BigDecimal,
    val disabled: BigDecimal,
    val community: BigDecimal,
    val youngPeople: BigDecimal,
    val interCommunity: BigDecimal,
    val languages: String
)
