package guru.springframework.msscbrewery.web.controller.v2

import guru.springframework.msscbrewery.config.AppConfig.Companion.API_BEER_V1_PATH
import guru.springframework.msscbrewery.config.AppConfig.Companion.API_BEER_V2_PATH
import guru.springframework.msscbrewery.config.AppConfig.Companion.MOCK_HOST_PORT
import guru.springframework.msscbrewery.services.v2.BeerServiceV2
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Validated
@RestController
@RequestMapping("/$API_BEER_V2_PATH")
open class BeerControllerV2(private val beerService: BeerServiceV2) {

    @GetMapping("/{beerId}")
    fun getBeer(@NotNull @PathVariable("beerId") beerId: UUID): ResponseEntity<BeerDtoV2> =
        ResponseEntity.ok(beerService.getBeerById(beerId)!!)

    @PostMapping
    fun addBeer(@Valid @NotNull @RequestBody beerDto: BeerDtoV2): ResponseEntity<Any> {
        val saved = beerService.saveNewBeer(beerDto)
        val headers = HttpHeaders()
        headers.add("Location", "$MOCK_HOST_PORT/$API_BEER_V1_PATH/${saved?.id}")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{beerId}")
    fun updateBeer(@PathVariable("beerId") beerId: UUID, @Valid @RequestBody beerDto: BeerDtoV2): ResponseEntity<Any> {
        beerService.updateBeer(beerId, beerDto)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBeer(@PathVariable("beerId") beerId: UUID) {
        beerService.deleteById(beerId)
    }
}