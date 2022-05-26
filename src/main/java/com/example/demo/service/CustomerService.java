package com.example.demo.service;

import java.util.HashMap;

public interface CustomerService {
    HashMap<String, Object> GetDataCusByLimit(String record) throws Exception;
}
