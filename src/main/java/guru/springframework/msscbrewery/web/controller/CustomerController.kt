package guru.springframework.msscbrewery.web.controller

import guru.springframework.msscbrewery.config.AppConfig
import guru.springframework.msscbrewery.config.AppConfig.Companion.API_CUSTOMER_V1_PATH
import guru.springframework.msscbrewery.services.CustomerService
import guru.springframework.msscbrewery.web.model.CustomerDto
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/$API_CUSTOMER_V1_PATH")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getCustomer(@PathVariable("customerId") customerId: UUID): ResponseEntity<CustomerDto> =
        ResponseEntity.ok(customerService.getById(customerId))

    @PostMapping
    fun addCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<Any> {
        val saved = customerService.saveNewCustomer(customerDto)
        val headers = HttpHeaders()
        headers.add("Location", "${AppConfig.MOCK_HOST_PORT}/$API_CUSTOMER_V1_PATH/${saved.id}")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{customerId}")
    fun updateCustomer(
        @RequestBody customerDto: CustomerDto,
        @PathVariable("customerId") customerId: UUID,
    ): ResponseEntity<Any> {
        customerService.updateCustomer(customerId, customerDto)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable("customerId") customerId: UUID) {
        customerService.deleteById(customerId)
    }
}