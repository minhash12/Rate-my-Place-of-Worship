package rmpw.model

import java.util.*

data class RatingInput(

    val placeOfWorshipId: UUID,

    val age: AgeCategories,

    val gender: GenderCategories,

    val ethnicity: EthnicityCategories,

    val welcomingAtmosphere: Int?,

    val facilities: Int?,

    val toilets: Int?,

    val carParking: Int?,

    val publicTransport: Int?,

    val cycle: Int?,

    val disabled: Int?,

    val community: Int?,

    val youngPeople: Int?,

    val interCommunity: Int?,

    val languages: String?,

    val comment: String?
)
