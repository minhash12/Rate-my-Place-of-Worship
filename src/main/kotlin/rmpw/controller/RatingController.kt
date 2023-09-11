package rmpw.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import rmpw.model.RatingInput
import rmpw.service.RatingService
import java.util.UUID

@Controller
@CrossOrigin
@RequestMapping("/place-of-worship/rating")
class RatingController(
    private val ratingService: RatingService
) {

    @Operation(summary = "Submit a rating for a place of worship", description = "Allow the user a to add a rating")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Unable to add rating")
        ]
    )
    @PostMapping("/submit", consumes = ["application/json"])
    fun submitRating(@RequestBody ratingInput: RatingInput): ResponseEntity<UUID> {
        val ratingId = ratingService.submitRating(ratingInput)
        return ResponseEntity(ratingId, HttpStatusCode.valueOf(200))
    }
}
