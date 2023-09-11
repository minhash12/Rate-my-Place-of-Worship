package rmpw.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import rmpw.entities.PlaceOfWorshipEntity
import java.util.*

interface PlaceOfWorshipRepository : CrudRepository<PlaceOfWorshipEntity, UUID> {

    @Query("SELECT DISTINCT p.type FROM PlaceOfWorshipEntity p")
    fun findDistinctTypes(): List<String>

    fun findAllByIdIn(ids: List<UUID>): List<PlaceOfWorshipEntity>
}
