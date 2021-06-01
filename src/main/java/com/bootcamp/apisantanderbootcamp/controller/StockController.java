package com.bootcamp.apisantanderbootcamp.controller;

import com.bootcamp.apisantanderbootcamp.dto.StockDTO;
import com.bootcamp.apisantanderbootcamp.exceptions.StockAlreadyRegisteredException;
import com.bootcamp.apisantanderbootcamp.exceptions.StockNotFoundException;
import com.bootcamp.apisantanderbootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) throws StockAlreadyRegisteredException {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {
        return ResponseEntity.ok(service.findALl());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable Long id) throws StockNotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto) throws StockAlreadyRegisteredException {
        return ResponseEntity.ok(service.replace(dto));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id) throws StockNotFoundException {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday() throws StockNotFoundException {
        return ResponseEntity.ok(service.findByToday());
    }

}
