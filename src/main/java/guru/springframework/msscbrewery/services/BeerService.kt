package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.Beer
import java.util.*

interface BeerService {
    fun getBeerById(beerId: UUID): Beer
    fun saveNewBeer(beerDto: Beer): Beer
    fun updateBeer(beerId: UUID, beerDto: Beer)
    fun deleteById(beerId: UUID)
}