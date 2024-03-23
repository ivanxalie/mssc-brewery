package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.Customer
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerServiceImpl : CustomerService {
    override fun getCustomerById(customerId: UUID): Customer =
        Customer.builder()
            .name("Ulfric Stormcloak")
            .id(UUID.randomUUID())
            .build()
}