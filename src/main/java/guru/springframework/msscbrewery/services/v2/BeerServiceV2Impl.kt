package guru.springframework.msscbrewery.services.v2

import guru.springframework.msscbrewery.web.model.v2.BeerV2
import org.springframework.stereotype.Component
import java.util.*

@Component
class BeerServiceV2Impl : BeerServiceV2 {
    override fun getBeerById(beerId: UUID): BeerV2? {
        return null
    }

    override fun saveNewBeer(beerDto: BeerV2): BeerV2? {
        return null
    }

    override fun updateBeer(beerId: UUID, beerDto: BeerV2) {
    }

    override fun deleteById(beerId: UUID) {
    }
}