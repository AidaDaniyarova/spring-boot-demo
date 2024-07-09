package com.spring.java.demo.services;

import com.spring.java.demo.model.AddressModel;
import com.spring.java.demo.repositories.AddressRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Optional<AddressModel> getAddressById(Long id){
        return addressRepo.findById(id);
    }

    public boolean existsById(Long id) {
        return addressRepo.existsById(id);
    }

    public AddressModel getDefaultAddress() {
        return addressRepo.findById(1L).orElseThrow(() -> new IllegalArgumentException("Default address not found"));
    }

    public List<AddressModel> getAllAddresses() {
        return addressRepo.findAll();
    }
}
