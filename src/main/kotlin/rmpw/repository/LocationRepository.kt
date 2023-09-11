package rmpw.repository

import org.locationtech.jts.geom.Point
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import rmpw.entities.LocationEntity
import java.util.UUID

@Repository
interface LocationRepository : CrudRepository<LocationEntity, UUID> {

    @Query(value = "SELECT * from locations where ST_DistanceSphere(location, :p) < :distance", nativeQuery = true)
    fun findAllPlacesOfWorshipWithinRadius(p: Point, distance: Double): List<LocationEntity>
}
