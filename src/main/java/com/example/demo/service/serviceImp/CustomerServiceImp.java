package com.example.demo.service.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.components.ResponseHelper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ResponseHelper responseHelper;
    private final JdbcTemplate jdbcTemplate;

    public CustomerServiceImp(CustomerRepository customerRepository, ResponseHelper responseHelper,
            JdbcTemplate jdbcTemplate) {
        this.customerRepository = customerRepository;
        this.responseHelper = responseHelper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public HashMap<String, Object> GetDataCusByLimit(String record) throws Exception {
        List<Map<String, Object>> response = this.jdbcTemplate.queryForList("select *from cus_data limit " + record);
        return this.responseHelper.success(response, "success");
    }
}
