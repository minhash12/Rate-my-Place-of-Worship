package rmpw.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rmpw.mapper.EntityMapper
import rmpw.model.RatingInput
import rmpw.repository.PlaceOfWorshipRepository
import rmpw.repository.RatingRepository
import java.util.UUID

@Service
class RatingService(
    private val ratingRepositories: RatingRepository,
    private val placeOfWorshipRepository: PlaceOfWorshipRepository,
    private val entityMapper: EntityMapper
) {

    @Transactional
    fun submitRating(ratingInput: RatingInput): UUID {
        val placeOfWorshipEntity = placeOfWorshipRepository.findById(ratingInput.placeOfWorshipId).get()
        val id = UUID.randomUUID()
        val ratingEntity = entityMapper.mapRatingInputToRatingEntity(ratingInput, id, placeOfWorshipEntity)
        placeOfWorshipEntity.ratings.add(ratingEntity)
        placeOfWorshipRepository.save(placeOfWorshipEntity)
        return id
    }
}
