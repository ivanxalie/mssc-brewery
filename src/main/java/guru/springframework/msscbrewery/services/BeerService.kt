package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.BeerDto
import java.util.*

interface BeerService {
    fun getBeerById(beerId: UUID): BeerDto
    fun saveNewBeer(beerDto: BeerDto): BeerDto
    fun updateBeer(beerId: UUID, beerDto: BeerDto)
    fun deleteById(beerId: UUID)
}