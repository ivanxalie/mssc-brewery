package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.BeerDto
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import java.util.*

@Service
class BeerServiceImpl : BeerService {
    @GetMapping("/{beerId}")
    override fun getBeerById(beerId: UUID): BeerDto =
        BeerDto.builder()
            .id(beerId)
            .beerName("lager")
            .beerStyle("light")
            .upc(123L)
            .build()
}