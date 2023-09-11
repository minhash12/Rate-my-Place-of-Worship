package rmpw.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import rmpw.model.AgeCategories
import rmpw.model.EthnicityCategories
import rmpw.model.GenderCategories
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "ratings")
class RatingEntity(
    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: UUID,

    @Column(name = "age", nullable = true)
    val age: AgeCategories,

    @Column(name = "gender", nullable = true)
    val gender: GenderCategories,

    @Column(name = "ethnicity", nullable = true)
    val ethnicity: EthnicityCategories,

    @Column(name = "welcoming", nullable = true)
    val welcomingAtmosphere: Int?,

    @Column(name = "facilities", nullable = true)
    val facilities: Int?,

    @Column(name = "toilets", nullable = true)
    val toilets: Int?,

    @Column(name = "car_parking", nullable = true)
    val carParking: Int?,

    @Column(name = "public_transport", nullable = true)
    val publicTransport: Int?,

    @Column(name = "cycle", nullable = true)
    val cycle: Int?,

    @Column(name = "disabled", nullable = true)
    val disabled: Int?,

    @Column(name = "community", nullable = true)
    val community: Int?,

    @Column(name = "young_people", nullable = true)
    val youngPeople: Int?,

    @Column(name = "inter_community", nullable = true)
    val interCommunity: Int?,

    @Column(name = "languages", nullable = true)
    val languages: String?

) {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "place_of_worship_id", nullable = false)
    var placeOfWorshipId: PlaceOfWorshipEntity? = null

    @OneToOne(mappedBy = "ratingId", cascade = [CascadeType.ALL], orphanRemoval = true)
    var comment: CommentEntity? = null

    @field:CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private val createdAt: Timestamp? = null

    @field:UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private val updatedAt: Timestamp? = null
}
