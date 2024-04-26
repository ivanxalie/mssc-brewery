package guru.springframework.msscbrewery.services.v2

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2
import java.util.*

interface BeerServiceV2 {
    fun getBeerById(beerId: UUID): BeerDtoV2?
    fun saveNewBeer(beerDto: BeerDtoV2): BeerDtoV2?
    fun updateBeer(beerId: UUID, beerDto: BeerDtoV2)
    fun deleteById(beerId: UUID)
}