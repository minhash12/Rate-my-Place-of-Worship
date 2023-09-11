package rmpw.mapper

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.PrecisionModel
import org.springframework.stereotype.Component
import rmpw.entities.CommentEntity
import rmpw.entities.LocationEntity
import rmpw.entities.PlaceOfWorshipEntity
import rmpw.entities.RatingEntity
import rmpw.model.Location
import rmpw.model.LocationInput
import rmpw.model.PlaceOfWorshipComments
import rmpw.model.PlaceOfWorshipDetail
import rmpw.model.PlaceOfWorshipInput
import rmpw.model.PlaceOfWorshipSummary
import rmpw.model.RatingInput
import java.util.*

@Component
class EntityMapper {

    fun mapPlaceOfWorshipEntityToPlaceOfWorshipSummary(placeOfWorshipEntity: PlaceOfWorshipEntity): PlaceOfWorshipSummary {
        val location = mapLocationEntityToLocation(placeOfWorshipEntity.location!!)
        return PlaceOfWorshipSummary(placeOfWorshipEntity.id, placeOfWorshipEntity.name, placeOfWorshipEntity.type, location)
    }
    fun mapPlaceOfWorshipEntityToPlaceOfWorshipDetail(placeOfWorshipEntity: PlaceOfWorshipEntity): PlaceOfWorshipDetail {
        val location = mapLocationEntityToLocation(placeOfWorshipEntity.location!!)
        return PlaceOfWorshipDetail(placeOfWorshipEntity.id, placeOfWorshipEntity.name, placeOfWorshipEntity.type, location, placeOfWorshipEntity.website)
    }

    fun mapLocationEntityToLocation(locationEntity: LocationEntity): Location {
        return Location(locationEntity.id, locationEntity.location.x, locationEntity.location.y, locationEntity.address, locationEntity.postcode)
    }
    fun mapLocationInputToLocationEntity(locationInput: LocationInput): LocationEntity {
        val factory = GeometryFactory(PrecisionModel(), 4326)
        val point = factory.createPoint(Coordinate(locationInput.longitude, locationInput.latitude))
        return LocationEntity(locationInput.address, locationInput.postcode, point)
    }

    fun mapCommentsToPlaceOfWorshipComments(id: UUID, comments: List<String>): PlaceOfWorshipComments {
        return PlaceOfWorshipComments(id, comments)
    }

    fun mapRatingInputToRatingEntity(ratingInput: RatingInput, id: UUID, placeOfWorshipEntity: PlaceOfWorshipEntity): RatingEntity {
        val ratingEntity = RatingEntity(
            id = id,
            age = ratingInput.age,
            gender = ratingInput.gender,
            ethnicity = ratingInput.ethnicity,
            welcomingAtmosphere = ratingInput.welcomingAtmosphere,
            facilities = ratingInput.facilities,
            toilets = ratingInput.toilets,
            carParking = ratingInput.carParking,
            publicTransport = ratingInput.publicTransport,
            cycle = ratingInput.cycle,
            disabled = ratingInput.disabled,
            community = ratingInput.community,
            youngPeople = ratingInput.youngPeople,
            interCommunity = ratingInput.interCommunity,
            languages = ratingInput.languages
        )
        val commentEntity = CommentEntity(ratingInput.comment)
        ratingEntity.comment = commentEntity
        commentEntity.ratingId = ratingEntity
        ratingEntity.placeOfWorshipId = placeOfWorshipEntity
        return ratingEntity
    }

    fun mapPlaceOfWorshipInputToPlaceOfWorshipEntity(placeOfWorshipInput: PlaceOfWorshipInput): PlaceOfWorshipEntity {
        return PlaceOfWorshipEntity(placeOfWorshipInput.name, placeOfWorshipInput.type, placeOfWorshipInput.website)
    }
}
