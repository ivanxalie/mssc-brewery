package guru.springframework.msscbrewery.services

import guru.springframework.msscbrewery.web.model.CustomerDto
import java.util.*

interface CustomerService {
    fun getById(customerId: UUID): CustomerDto
    fun saveNewCustomer(customerDto: CustomerDto): CustomerDto
    fun updateCustomer(customerId: UUID, customerDto: CustomerDto)
    fun deleteById(customerId: UUID)
}