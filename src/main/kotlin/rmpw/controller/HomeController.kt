package rmpw.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import rmpw.model.POWTypes
import rmpw.model.PlaceOfWorshipSearch
import rmpw.model.SearchResults
import rmpw.service.PlaceOfWorshipService
import java.util.*

@Controller
@CrossOrigin
@RequestMapping("/home")
class HomeController(
    private val placeOfWorshipService: PlaceOfWorshipService
) {

    @Operation(summary = "Fetches the different types of places of worship", description = "Returns different types of places of worship")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Unable to fetch types")
        ]
    )
    @GetMapping("/")
    fun getTypesOfPlacesOfWorship(): ResponseEntity<POWTypes> {
        val placesOfWorshipResponse = placeOfWorshipService.findDistinctTypesOfPlacesOfWorship()
        return ResponseEntity.ok(POWTypes(placesOfWorshipResponse))
    }

    @Operation(summary = "Fetches the places of worship matching the search criteria", description = "Returns a summary of places of worship")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Unable to find places of worship")
        ]
    )
    @GetMapping("/search")
    fun getPlacesOfWorship(search: PlaceOfWorshipSearch): ResponseEntity<SearchResults> {
        val placesOfWorship = placeOfWorshipService.searchPlacesOfWorship(search)
        return ResponseEntity.ok(SearchResults(placesOfWorship))
    }
}
