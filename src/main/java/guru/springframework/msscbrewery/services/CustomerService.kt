package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.Customer
import java.util.*

interface CustomerService {
    fun getCustomerById(customerId: UUID): Customer
}