package rmpw.service

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import rmpw.model.LocationInput
import rmpw.model.POWType
import rmpw.model.PlaceOfWorshipInput
import rmpw.repository.SeedDataRepository

@Service
class SeedDataService(
    private val seedDataRepository: SeedDataRepository,
    private val placeOfWorshipService: PlaceOfWorshipService
) {

    @PostConstruct
    fun seedData() {
        val place = "Reading"
        val seedDataEntity = seedDataRepository.findByPlaceEqualsIgnoreCase(place)
        if (seedDataEntity != null && !seedDataEntity.seeded) {
            val places = generateData()
            places.map {
                placeOfWorshipService.addPlaceOfWorship(it)
            }
            seedDataEntity.seeded = true
            seedDataRepository.save(seedDataEntity)
        }


    }

    fun generateData(): List<PlaceOfWorshipInput> {
        val place1 = PlaceOfWorshipInput(
            name = "The Sikh Centre, Ramgarhia Sabha Reading",
            type = POWType.GUDWARA,
            location = LocationInput(
                longitude = -0.9583493,
                latitude = 51.4489914,
                address = "Reading",
                postcode = "RG6 1AH"
            ),
            website = "The Sikh Centre, Ramgarhia Sabha Reading"
        )
        val place2 = PlaceOfWorshipInput(
            name = "Reading Hindu Temple",
            type = POWType.TEMPLE,
            location = LocationInput(
                longitude = -1.0218483,
                latitude = 51.4441881,
                address = "Reading",
                postcode = "RG2 0EQ"
            ),
            website = "Reading Hindu Temple"
        )
        val place3 = PlaceOfWorshipInput(
            name = "Reading Hebrew Congregation",
            type = POWType.SYNANGOUGE,
            location = LocationInput(
                longitude = -1.0218483,
                latitude = 51.4544114,
                address = "Reading",
                postcode = "RG1 7YB"
            ),
            website = "Reading Hebrew Congregation"
        )
        val place4 = PlaceOfWorshipInput(
            name = "Reading Ukrainian Community Centre",
            type = POWType.OTHER,
            location = LocationInput(
                longitude = -0.9735083,
                latitude = 51.4527392,
                address = "Reading",
                postcode = "RG1 4QZ"
            ),
            website = "Reading Ukrainian Community Centre"
        )
        val place5 = PlaceOfWorshipInput(
            name = "Abu Bakr Mosque",
            type = POWType.MOSQUE,
            location = LocationInput(
                longitude = -1.0340559,
                latitude = 51.4568983,
                address = "Reading",
                postcode = "RG30 1AF"
            ),
            website = "Abu Bakr Mosque"
        )
        val place6 = PlaceOfWorshipInput(
            name = "Reading Chinese Christian Church",
            type = POWType.CHURCH,
            location = LocationInput(
                longitude = -0.9925997,
                latitude = 51.4515998,
                address = "Reading",
                postcode = "RG1 4LS"
            ),
            website = "Reading Chinese Christian Church"
        )
        val place7 = PlaceOfWorshipInput(
            name = "St James Church Centre",
            type = POWType.CHURCH,
            location = LocationInput(
                longitude = -0.945307,
                latitude = 51.4460367,
                address = "Reading",
                postcode = "RG5 3LH"
            ),
            website = "St James Church Centre"
        )
        val place8 = PlaceOfWorshipInput(
            name = "Sri Guru Singh Sabha Gurdwara Reading",
            type = POWType.GUDWARA,
            location = LocationInput(
                longitude = -0.9583493,
                latitude = 51.4489914,
                address = "Reading",
                postcode = "RG1 3LB"
            ),
            website = "Sri Guru Singh Sabha Gurdwara Reading"
        )

        return listOf(place1, place2, place3, place4, place5, place6, place7, place8)
    }
}
