package com.prueba.civa.controller;

import com.prueba.civa.models.Bus;
import com.prueba.civa.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/bus")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Page<Bus>> getAllBuses(Pageable pageable) {
        Page<Bus> buses = busService.getAllBuses(pageable);
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/bus/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Bus> getBusById(@PathVariable Integer id) {
        Optional<Bus> bus = busService.getBusById(id);
        return bus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
