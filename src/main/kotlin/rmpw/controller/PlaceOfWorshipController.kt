package rmpw.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import rmpw.model.PlaceOfWorshipComments
import rmpw.model.PlaceOfWorshipDetail
import rmpw.model.PlaceOfWorshipInput
import rmpw.model.PlaceOfWorshipScore
import rmpw.service.PlaceOfWorshipService
import java.util.*

@Controller
@CrossOrigin
@RequestMapping("/place-of-worship")
class PlaceOfWorshipController
(private val placeOfWorshipService: PlaceOfWorshipService) {

    @Operation(summary = "Fetches details on a places of worship", description = "Returns 200 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Unable to find place of worship")
        ]
    )
    @GetMapping("/{id}/details")
    fun getPlaceOfWorshipDetails(@PathVariable id: UUID): ResponseEntity<PlaceOfWorshipDetail> {
        val placeOfWorshipDetail = placeOfWorshipService.getPlaceOfWorshipDetails(id)
        return ResponseEntity(placeOfWorshipDetail, HttpStatusCode.valueOf(200))
    }

    @Operation(summary = "Fetches ratings of a places of worship", description = "Returns the scores for the place of worship")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Unable to find place of worship")
        ]
    )
    @GetMapping("/{id}/ratings")
    fun getPlaceOfWorshipRatings(@PathVariable id: UUID): ResponseEntity<PlaceOfWorshipScore> {
        val placeOfWorshipScore = placeOfWorshipService.getPlaceOfWorshipRatings(id)
        return ResponseEntity(placeOfWorshipScore, HttpStatusCode.valueOf(200))
    }

    @Operation(summary = "Fetches the comments on a places of worship", description = "Returns comments on the place of worship")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Unable to fetch types")
        ]
    )
    @GetMapping("/{id}/comments")
    fun getPlaceOfWorshipComments(@PathVariable id: UUID): ResponseEntity<PlaceOfWorshipComments> {
        val placeOfWorshipComments = placeOfWorshipService.getPlaceOfWorshipComments(id)
        return ResponseEntity(placeOfWorshipComments, HttpStatusCode.valueOf(200))
    }

    @Operation(summary = "Add a new place of worship", description = "Returns place of worship id")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully Added"),
            ApiResponse(responseCode = "201", description = "Already Exists"),
            ApiResponse(responseCode = "404", description = "Unable to add")
        ]
    )
    @PostMapping("/submit", consumes = ["application/json"])
    fun addPlaceOfWorship(@RequestBody placeOfWorshipInput: PlaceOfWorshipInput): ResponseEntity<UUID> {
        val id = placeOfWorshipService.addPlaceOfWorship(placeOfWorshipInput)
        return ResponseEntity(id, HttpStatusCode.valueOf(200))
    }
}
