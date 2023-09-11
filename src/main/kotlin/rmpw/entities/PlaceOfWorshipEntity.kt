package rmpw.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.UpdateTimestamp
import rmpw.model.POWType
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "place_of_worship")
data class PlaceOfWorshipEntity(
    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: POWType,

    @Column(name = "website", nullable = true)
    val website: String?

) {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: UUID = UUID.randomUUID()

    @OneToOne(mappedBy = "placeOfWorshipId", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    var location: LocationEntity? = null

    @OneToMany(mappedBy = "placeOfWorshipId", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    var ratings: MutableList<RatingEntity> = mutableListOf()

    @field:CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private val createdAt: Timestamp? = null

    @field:UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private val updatedAt: Timestamp? = null
}
