package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.Beer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerServiceImpl() : BeerService {
    companion object {
        val log: Logger = LoggerFactory.getLogger(BeerServiceImpl::class.java)
    }

    override fun getBeerById(beerId: UUID): Beer =
        Beer.builder()
            .id(UUID.randomUUID())
            .beerName("Galaxy Cat")
            .beerStyle("pale Ale")
            .build()

    override fun saveNewBeer(beerDto: Beer): Beer =
        Beer.builder()
            .id(UUID.randomUUID())
            .build()

    override fun updateBeer(beerId: UUID, beerDto: Beer) {
        log.debug("Updated beer with id {}!", beerId)
    }

    override fun deleteById(beerId: UUID) {
        log.debug("Deleted beer with id {}!", beerId)
    }
}