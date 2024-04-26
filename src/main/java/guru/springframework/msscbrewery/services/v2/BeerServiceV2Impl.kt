package guru.springframework.msscbrewery.services.v2

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2
import org.springframework.stereotype.Component
import java.util.*

@Component
class BeerServiceV2Impl : BeerServiceV2 {
    override fun getBeerById(beerId: UUID): BeerDtoV2? {
        return null
    }

    override fun saveNewBeer(beerDto: BeerDtoV2): BeerDtoV2? {
        return null
    }

    override fun updateBeer(beerId: UUID, beerDto: BeerDtoV2) {
    }

    override fun deleteById(beerId: UUID) {
    }
}