// src/main/java/com/chanock/papelon_backend/service/CustomerServiceImpl.java
package com.chanock.papelon_backend.service;

import com.chanock.papelon_backend.exception.ResourceNotFoundException;
import com.chanock.papelon_backend.model.Customers;
import com.chanock.papelon_backend.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomersRepository repo;

    @Override
    public List<Customers> findAll() {
        return repo.findAll();
    }

    @Override
    public Customers findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", id));
    }

    @Override
    public Customers create(Customers c) {
        return repo.save(c);
    }

    @Override
    public Customers update(Long id, Customers c) {
        Customers existing = findById(id);
        existing.setName(c.getName());
        existing.setEmail(c.getEmail());
        existing.setPhone(c.getPhone());
        existing.setAddress(c.getAddress());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        var c = findById(id);
        repo.delete(c);
    }
}
