package rmpw.calculator

import org.springframework.stereotype.Component
import rmpw.entities.PlaceOfWorshipEntity
import rmpw.entities.RatingEntity
import rmpw.model.PlaceOfWorshipScore
import java.math.BigDecimal
import java.math.RoundingMode

@Component
class ScoreCalculator {

   /*
   * TODO , if i had time i would have added filters here on age , gender, ethnicity
    */

    fun calculateScore(ratings: List<RatingEntity>, placeOfWorshipEntity: PlaceOfWorshipEntity): PlaceOfWorshipScore {
        var welcomingScore = 0
        var welcomingTotal = 0
        var facilitiesScore = 0
        var facilitiesTotal = 0
        var toiletsScore = 0
        var toiletsTotal = 0
        var carParkingScore = 0
        var carParkingTotal = 0
        var publicTransportScore = 0
        var publicTransportTotal = 0
        var cycleScore = 0
        var cycleTotal = 0
        var disabledScore = 0
        var disabledTotal = 0
        var communityScore = 0
        var communityTotal = 0
        var youngPeopleScore = 0
        var youngPeopleTotal = 0
        var interCommunityScore = 0
        var interCommunityTotal = 0

        for (rating in ratings) {
            if (rating.welcomingAtmosphere != null) {
                welcomingScore += rating.welcomingAtmosphere
                welcomingTotal++
            }
            if (rating.facilities != null) {
                facilitiesScore += rating.facilities
                facilitiesTotal++
            }
            if (rating.toilets != null) {
                toiletsScore += rating.toilets
                toiletsTotal++
            }
            if (rating.carParking != null) {
                carParkingScore += rating.carParking
                carParkingTotal++
            }
            if (rating.publicTransport != null) {
                publicTransportScore += rating.publicTransport
                publicTransportTotal++
            }
            if (rating.cycle != null) {
                cycleScore += rating.cycle
                cycleTotal++
            }
            if (rating.disabled != null) {
                disabledScore += rating.disabled
                disabledTotal++
            }
            if (rating.community != null) {
                communityScore += rating.community
                communityTotal++
            }
            if (rating.youngPeople != null) {
                youngPeopleScore += rating.youngPeople
                youngPeopleTotal++
            }
            if (rating.interCommunity != null) {
                interCommunityScore += rating.interCommunity
                interCommunityTotal++
            }
        }

        val welcoming = generateScoreValue(welcomingScore, welcomingTotal)
        val facilities = generateScoreValue(facilitiesScore, facilitiesTotal)
        val toilets = generateScoreValue(toiletsScore, toiletsTotal)
        val carParking = generateScoreValue(carParkingScore, carParkingTotal)
        val publicTransport = generateScoreValue(publicTransportScore, publicTransportTotal)
        val cycling = generateScoreValue(cycleScore, cycleTotal)
        val disabled = generateScoreValue(disabledScore, disabledTotal)
        val community = generateScoreValue(communityScore, communityTotal)
        val youngPeople = generateScoreValue(youngPeopleScore, youngPeopleTotal)
        val interCommunity = generateScoreValue(interCommunityScore, interCommunityTotal)

        return PlaceOfWorshipScore(
            placeOfWorshipEntity.id, placeOfWorshipEntity.name, placeOfWorshipEntity.type,
            welcoming, facilities, toilets, carParking, publicTransport, cycling, disabled, community,
            youngPeople, interCommunity, ""
        )
    }

    private fun generateScoreValue(score: Int, total: Int): BigDecimal {
        if (total == 0) return BigDecimal.ZERO
        return (score / total).toBigDecimal().setScale(1, RoundingMode.CEILING)
    }
}
