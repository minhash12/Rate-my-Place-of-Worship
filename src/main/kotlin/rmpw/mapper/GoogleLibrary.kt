package rmpw.mapper

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import com.google.maps.model.GeocodingResult
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import rmpw.model.LocationInput

@Service
class GoogleLibrary {

    @Value("\${google.api.key}")
    private lateinit var googleApiKey: String

    fun findLocation(address: String): LocationInput {
        val context: GeoApiContext = GeoApiContext.Builder()
            .apiKey(googleApiKey)
            .build()
        val results: Array<GeocodingResult> = GeocodingApi.geocode(
            context,
            address
        ).await()
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        System.out.println(gson.toJson(results[0].addressComponents))
        val longitude = results[0].geometry.location.lng
        val lattitude = results[0].geometry.location.lat
        val formattedAddress = results[0].formattedAddress
        // TODO later
        // val postCodeComponent = results[0].addressComponents.filter { it.types.contains(AddressComponentType.POSTAL_CODE) }
        context.shutdown()
        return LocationInput(longitude, lattitude, formattedAddress, "")
    }
}
