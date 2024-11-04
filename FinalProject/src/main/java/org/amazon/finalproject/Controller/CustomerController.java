package org.amazon.finalproject.Controller;


import org.amazon.finalproject.DTO.CustomerRequestDTO;
import org.amazon.finalproject.Model.Customer;
import org.amazon.finalproject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequestDTO customer) {
    Customer customer1 = customerService.addCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody CustomerRequestDTO customer) {
        Optional<Customer> customer1 = customerService.updateCustomer(id,customer);
        if (customer1.isPresent()) {
            return ResponseEntity.ok(customer1.get());
        } else
            return ResponseEntity.notFound().build();
    }

}
