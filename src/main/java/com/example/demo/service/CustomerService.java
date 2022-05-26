package com.example.demo.service;

import java.util.HashMap;

import com.example.demo.model.CustomerModel;

public interface CustomerService {
    HashMap<String, Object> GetDataCusByLimit(String record) throws Exception;

    HashMap<String, Object> DelDataCusQue(long id) throws Exception;

    HashMap<String, Object> UpdateDataCusQue(long id, CustomerModel customerModel) throws Exception;

    HashMap<String, Object> CreateDataCusQue(long record, CustomerModel customerModel) throws Exception;
}
