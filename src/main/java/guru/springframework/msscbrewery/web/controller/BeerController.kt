package guru.springframework.msscbrewery.web.controller

import guru.springframework.msscbrewery.services.BeerService
import guru.springframework.msscbrewery.web.model.BeerDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/beer")
class BeerController(private val beerService: BeerService) {
    @GetMapping("/{beerId}")
    fun getBeer(@PathVariable("beerId") beerId: UUID): ResponseEntity<BeerDto> =
        ResponseEntity.ok(beerService.getBeerById(beerId))
}