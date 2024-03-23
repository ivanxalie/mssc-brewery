package guru.springframework.msscbrewery.web.controller

import guru.springframework.msscbrewery.services.CustomerService
import guru.springframework.msscbrewery.web.model.Customer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getCustomer(@PathVariable("customerId") customerId: UUID): ResponseEntity<Customer> =
        ResponseEntity.ok(customerService.getCustomerById(customerId))
}