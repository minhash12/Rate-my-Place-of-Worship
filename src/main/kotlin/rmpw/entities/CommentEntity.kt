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
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "comments")
class CommentEntity(

    @Column(name = "comment", nullable = true)
    val comment: String?
) {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: UUID = UUID.randomUUID()

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rating_id", nullable = false)
    var ratingId: RatingEntity? = null

    @field:CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private val createdAt: Timestamp? = null

    @field:UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private val updatedAt: Timestamp? = null
}
