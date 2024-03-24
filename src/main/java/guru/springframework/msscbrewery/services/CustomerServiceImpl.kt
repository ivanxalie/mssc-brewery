package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.Customer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        val log: Logger = LoggerFactory.getLogger(CustomerServiceImpl::class.java)
    }

    override fun getById(customerId: UUID): Customer =
        Customer.builder()
            .name("Ulfric Stormcloak")
            .id(UUID.randomUUID())
            .build()

    override fun saveNewCustomer(customer: Customer): Customer =
        Customer.builder()
            .id(UUID.randomUUID())
            .build()

    override fun updateCustomer(customerId: UUID, customer: Customer) {
        log.debug("Updated customer with id {}!", customerId)
    }

    override fun deleteById(customerId: UUID) {
        log.debug("Deleted customer with id {}!", customerId)
    }
}