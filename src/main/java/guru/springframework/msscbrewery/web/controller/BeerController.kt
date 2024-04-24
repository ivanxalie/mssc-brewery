package guru.springframework.msscbrewery.web.controller

import guru.springframework.msscbrewery.config.AppConfig.Companion.API_BEER_V1_PATH
import guru.springframework.msscbrewery.config.AppConfig.Companion.MOCK_HOST_PORT
import guru.springframework.msscbrewery.services.BeerService
import guru.springframework.msscbrewery.web.model.Beer
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/$API_BEER_V1_PATH")
class BeerController(private val beerService: BeerService) {
    @GetMapping("/{beerId}")
    fun getBeer(@PathVariable("beerId") beerId: UUID): ResponseEntity<Beer> =
        ResponseEntity.ok(beerService.getBeerById(beerId))

    @PostMapping
    fun addBeer(@RequestBody beerDto: Beer): ResponseEntity<Any> {
        val saved: Beer = beerService.saveNewBeer(beerDto)
        val headers = HttpHeaders()
        headers.add("Location", "$MOCK_HOST_PORT/$API_BEER_V1_PATH/${saved.id}")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{beerId}")
    fun updateBeer(@RequestBody beerDto: Beer, @PathVariable("beerId") beerId: UUID): ResponseEntity<Any> {
        beerService.updateBeer(beerId, beerDto)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBeer(@PathVariable("beerId") beerId: UUID) {
        beerService.deleteById(beerId)
    }
}