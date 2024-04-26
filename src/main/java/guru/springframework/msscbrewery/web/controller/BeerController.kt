package guru.springframework.msscbrewery.web.controller

import guru.springframework.msscbrewery.config.AppConfig.Companion.API_BEER_V1_PATH
import guru.springframework.msscbrewery.config.AppConfig.Companion.MOCK_HOST_PORT
import guru.springframework.msscbrewery.services.BeerService
import guru.springframework.msscbrewery.web.model.BeerDto
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/$API_BEER_V1_PATH")
class BeerController(private val beerService: BeerService) {
    @GetMapping("/{beerId}")
    fun getBeer(@PathVariable("beerId") beerId: UUID): ResponseEntity<BeerDto> =
        ResponseEntity.ok(beerService.getBeerById(beerId))

    @PostMapping
    fun addBeer(@Valid @RequestBody beerDto: BeerDto): ResponseEntity<Any> {
        val saved: BeerDto = beerService.saveNewBeer(beerDto)
        val headers = HttpHeaders()
        headers.add("Location", "$MOCK_HOST_PORT/$API_BEER_V1_PATH/${saved.id}")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{beerId}")
    fun updateBeer(@PathVariable("beerId") beerId: UUID, @Valid @RequestBody beerDto: BeerDto): ResponseEntity<Any> {
        beerService.updateBeer(beerId, beerDto)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBeer(@PathVariable("beerId") beerId: UUID) {
        beerService.deleteById(beerId)
    }
}