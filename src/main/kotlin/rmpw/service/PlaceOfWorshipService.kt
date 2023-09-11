package rmpw.service

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.PrecisionModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rmpw.calculator.ScoreCalculator
import rmpw.mapper.EntityMapper
import rmpw.mapper.GoogleLibrary
import rmpw.model.PlaceOfWorshipComments
import rmpw.model.PlaceOfWorshipDetail
import rmpw.model.PlaceOfWorshipInput
import rmpw.model.PlaceOfWorshipScore
import rmpw.model.PlaceOfWorshipSearch
import rmpw.model.PlaceOfWorshipSummary
import rmpw.repository.LocationRepository
import rmpw.repository.PlaceOfWorshipRepository
import rmpw.repository.RatingRepository
import java.util.*

@Transactional
@Service
class PlaceOfWorshipService(
    private val placeOfWorshipRepository: PlaceOfWorshipRepository,
    private val locationRepository: LocationRepository,
    private val ratingRepository: RatingRepository,
    private val entityMapper: EntityMapper,
    private val scoreCalculator: ScoreCalculator,
    private val googleLibrary: GoogleLibrary
) {

    fun findDistinctTypesOfPlacesOfWorship(): List<String>	{
        val types = placeOfWorshipRepository.findDistinctTypes()
        println(types)
        return types
    }

    fun searchPlacesOfWorship(search: PlaceOfWorshipSearch): List<PlaceOfWorshipSummary> {
        println("Searching for ${search.type} within ${search.distance} KM of ${search.location}")

        val locationInput = googleLibrary.findLocation(search.location)
        val factory = GeometryFactory(PrecisionModel(), 4326)
        val point = factory.createPoint(Coordinate(locationInput.longitude, locationInput.latitude))
        val distanceInM = search.distance.toDouble() * 1000
        println("Searching near point long: ${point.x} lat: ${point.y}")
        val locations = locationRepository.findAllPlacesOfWorshipWithinRadius(point, distanceInM)
        val placesOfWorship = locations.mapNotNull { it.placeOfWorshipId }
        val matching = placesOfWorship.filter { it.type == search.type }
        return matching.map { entityMapper.mapPlaceOfWorshipEntityToPlaceOfWorshipSummary(it) }
    }

    fun getPlaceOfWorshipDetails(id: UUID): PlaceOfWorshipDetail {
        val placeOfWorshipEntity = placeOfWorshipRepository.findById(id)
        return entityMapper.mapPlaceOfWorshipEntityToPlaceOfWorshipDetail(placeOfWorshipEntity.get())
    }

    fun getPlaceOfWorshipRatings(id: UUID): PlaceOfWorshipScore {
        val placeOfWorshipEntity = placeOfWorshipRepository.findById(id).get()
        val ratings = ratingRepository.findAllByPlaceOfWorshipIdEquals(placeOfWorshipEntity)
        return scoreCalculator.calculateScore(ratings, placeOfWorshipEntity)
    }

    fun getPlaceOfWorshipComments(id: UUID): PlaceOfWorshipComments {
        val placeOfWorshipEntity = placeOfWorshipRepository.findById(id)
        val ratings = ratingRepository.findAllByPlaceOfWorshipIdEquals(placeOfWorshipEntity.get())
        val comments = ratings.mapNotNull { it.comment?.comment }
        return entityMapper.mapCommentsToPlaceOfWorshipComments(placeOfWorshipEntity.get().id, comments)
    }

    fun addPlaceOfWorship(placeOfWorshipInput: PlaceOfWorshipInput): UUID {
        val locationEntity = entityMapper.mapLocationInputToLocationEntity(placeOfWorshipInput.location)
        val placeOfWorshipEntity = entityMapper.mapPlaceOfWorshipInputToPlaceOfWorshipEntity(placeOfWorshipInput)
        placeOfWorshipEntity.location = locationEntity
        locationEntity.placeOfWorshipId = placeOfWorshipEntity
        val savedEntity = placeOfWorshipRepository.save(placeOfWorshipEntity)
        return savedEntity.id
    }
}
