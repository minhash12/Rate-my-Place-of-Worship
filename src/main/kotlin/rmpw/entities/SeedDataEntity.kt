package rmpw.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "seed_data")
class SeedDataEntity(

    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Int,

    @Column(name = "place", nullable = false)
    val place: String,

    @Column(name = "seeded", nullable = false)
    var seeded: Boolean

)
