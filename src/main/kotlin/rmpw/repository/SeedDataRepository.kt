package rmpw.repository

import org.springframework.data.jpa.repository.JpaRepository
import rmpw.entities.SeedDataEntity

interface SeedDataRepository : JpaRepository<SeedDataEntity, Int> {

    fun findByPlaceEqualsIgnoreCase(place: String): SeedDataEntity?
}
