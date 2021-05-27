package com.bootcamp.apisantanderbootcamp.controller;

import com.bootcamp.apisantanderbootcamp.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    List<StockDTO> list = new ArrayList<>();


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.of(Optional.of(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {
        StockDTO santander = new StockDTO(1L, "Santander", 198.0, 3.6, LocalDate.now());
        StockDTO pontoFrio = new StockDTO(2L, "Ponto Frio", 20.0, 23.0, LocalDate.now());
        list.add(santander);
        list.add(pontoFrio);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable Long id) {
        StockDTO stockById = list.stream().filter(x -> x.getId().compareTo(id) == 0)
                .findFirst().orElseThrow(NoSuchElementException::new);
        return ResponseEntity.ok(stockById);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }
}
