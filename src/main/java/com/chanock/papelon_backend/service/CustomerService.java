// src/main/java/com/chanock/papelon_backend/service/CustomerService.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.model.Customers;
import java.util.List;

public interface CustomerService {
    List<Customers> findAll();
    Customers findById(Long id);
    Customers create(Customers c);
    Customers update(Long id, Customers c);
    void delete(Long id);
}
