package rmpw.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rmpw.entities.PlaceOfWorshipEntity
import rmpw.entities.RatingScoreEntity
import java.util.UUID

@Repository
interface RatingScoreRepository : JpaRepository<RatingScoreEntity, UUID> {

    fun findByPlaceOfWorshipIdEquals(placeOfWorshipId: PlaceOfWorshipEntity): RatingScoreEntity
}
