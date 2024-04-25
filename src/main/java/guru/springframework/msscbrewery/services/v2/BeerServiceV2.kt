package guru.springframework.msscbrewery.services.v2

import guru.springframework.msscbrewery.web.model.v2.BeerV2
import java.util.*

interface BeerServiceV2 {
    fun getBeerById(beerId: UUID): BeerV2?
    fun saveNewBeer(beerDto: BeerV2): BeerV2?
    fun updateBeer(beerId: UUID, beerDto: BeerV2)
    fun deleteById(beerId: UUID)
}