package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.serviceImp.CustomerServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerServiceImp customerServiceImp;

    public CustomerController(CustomerServiceImp customerServiceImp) {
        this.customerServiceImp = customerServiceImp;
    }

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerModel>> getAllCustomers() {
        try {
            List<CustomerModel> customerModels = new ArrayList<CustomerModel>();
            customerRepository.findAll().forEach(customerModels::add);
            return new ResponseEntity<>(customerModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get by limit
    @GetMapping("/customersByLimit/{record}")
    public ResponseEntity<?> customersgetByLimit(@PathVariable("record") String record) throws Exception {
        return new ResponseEntity<>(this.customerServiceImp.GetDataCusByLimit(record), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerModel> createCustomers(@RequestBody CustomerModel customerModel) {
        try {
            CustomerModel _customerModel = customerRepository.save(new CustomerModel(customerModel.getFirst_name(),
                    customerModel.getLast_name(), customerModel.getBirth_date(), customerModel.getE_mail(),
                    customerModel.getPhone(), customerModel.getAddress()));
            return new ResponseEntity<CustomerModel>(_customerModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // create cus by query
    @PostMapping("/customersQue/{record}")
    public ResponseEntity<?> createCustomerQue(@PathVariable("record") long record,
            @RequestBody CustomerModel customerModel) throws Exception {
        return new ResponseEntity<>(this.customerServiceImp.CreateDataCusQue(record, customerModel), HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerModel> updateCustomers(@PathVariable("id") long id,
            @RequestBody CustomerModel customerModel) {
        Optional<CustomerModel> customerData = customerRepository.findById(id);
        if (customerData.isPresent()) {
            CustomerModel _customerModel = customerData.get();
            _customerModel.setFirst_name(customerModel.getFirst_name());
            _customerModel.setLast_name(customerModel.getLast_name());
            _customerModel.setBirth_date(customerModel.getBirth_date());
            _customerModel.setE_mail(customerModel.getE_mail());
            _customerModel.setPhone(customerModel.getPhone());
            _customerModel.setAddress(customerModel.getAddress());
            return new ResponseEntity<>(customerRepository.save(_customerModel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // update by que
    @PutMapping("/customerQue/{id}")
    public ResponseEntity<?> updateCustomerQue(@PathVariable("id") long id, @RequestBody CustomerModel customers)
            throws Exception {
        return new ResponseEntity<>(this.customerServiceImp.UpdateDataCusQue(id, customers), HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomers(@PathVariable("id") long id) {
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete by query
    @DeleteMapping("/customersQue/{id}")
    public ResponseEntity<?> deleteCustomersQue(@PathVariable("id") long id) throws Exception {
        return new ResponseEntity<>(this.customerServiceImp.DelDataCusQue(id), HttpStatus.OK);
    }

}
