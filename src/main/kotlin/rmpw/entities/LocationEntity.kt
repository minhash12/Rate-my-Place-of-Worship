package rmpw.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.locationtech.jts.geom.Point
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "locations")
class LocationEntity(

    @Column(name = "address", nullable = false)
    val address: String,

    @Column(name = "post_code", nullable = false)
    val postcode: String,

    @Column(name = "location", nullable = false)
    val location: Point
) {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: UUID = UUID.randomUUID()

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "place_of_worship_id", nullable = false)
    var placeOfWorshipId: PlaceOfWorshipEntity? = null

    @field:CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private val createdAt: Timestamp? = null

    @field:UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private val updatedAt: Timestamp? = null
}
