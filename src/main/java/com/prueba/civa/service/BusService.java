package com.prueba.civa.service;

import com.prueba.civa.models.Bus;
import com.prueba.civa.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public Page<Bus> getAllBuses(Pageable pageable) {
        return busRepository.findAll(pageable);
    }

    public Optional<Bus> getBusById(Integer id) {
        return busRepository.findById(id);
    }
}
