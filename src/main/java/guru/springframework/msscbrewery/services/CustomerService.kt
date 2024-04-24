package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.Customer
import java.util.*

interface CustomerService {
    fun getById(customerId: UUID): Customer
    fun saveNewCustomer(customerDto: Customer): Customer
    fun updateCustomer(customerId: UUID, customerDto: Customer)
    fun deleteById(customerId: UUID)
}