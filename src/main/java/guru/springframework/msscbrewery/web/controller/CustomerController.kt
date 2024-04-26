package guru.springframework.msscbrewery.web.controller

import guru.springframework.msscbrewery.config.AppConfig.Companion.API_CUSTOMER_V1_PATH
import guru.springframework.msscbrewery.config.AppConfig.Companion.MOCK_HOST_PORT
import guru.springframework.msscbrewery.services.CustomerService
import guru.springframework.msscbrewery.web.model.Customer
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/$API_CUSTOMER_V1_PATH")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/{customerId}")
    fun getCustomer(@PathVariable("customerId") customerId: UUID): ResponseEntity<Customer> =
        ResponseEntity.ok(customerService.getById(customerId))

    @PostMapping
    fun addCustomer(@Valid @RequestBody customerDto: Customer): ResponseEntity<Any> {
        val saved = customerService.saveNewCustomer(customerDto)
        val headers = HttpHeaders()
        headers.add("Location", "$MOCK_HOST_PORT/$API_CUSTOMER_V1_PATH/${saved.id}")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(NO_CONTENT)
    fun updateCustomer(
        @RequestBody @Valid customerDto: Customer,
        @PathVariable("customerId") customerId: UUID,
    ) {
        customerService.updateCustomer(customerId, customerDto)
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(NO_CONTENT)
    fun deleteCustomer(@PathVariable("customerId") customerId: UUID) {
        customerService.deleteById(customerId)
    }
}