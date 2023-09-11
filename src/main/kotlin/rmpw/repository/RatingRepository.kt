package rmpw.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rmpw.entities.PlaceOfWorshipEntity
import rmpw.entities.RatingEntity
import java.util.UUID

@Repository
interface RatingRepository : JpaRepository<RatingEntity, UUID> {

    fun findAllByPlaceOfWorshipIdEquals(placeOfWorshipEntity: PlaceOfWorshipEntity): List<RatingEntity>
}
