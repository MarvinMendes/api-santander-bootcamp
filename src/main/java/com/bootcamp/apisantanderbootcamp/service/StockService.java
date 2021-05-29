package com.bootcamp.apisantanderbootcamp.service;

import com.bootcamp.apisantanderbootcamp.dto.StockDTO;
import com.bootcamp.apisantanderbootcamp.entity.Stock;
import com.bootcamp.apisantanderbootcamp.mapper.StockMapper;
import com.bootcamp.apisantanderbootcamp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Stock save = mapper.toEntity(dto);
        repository.save(save);
        StockDTO stockDTO = mapper.toDTO(save);
        return stockDTO;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findALl() {
        List<Stock> stockList = repository.findAll();
        return stockList.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return getByIdOrElseThrow(id);
    }

    private StockDTO getByIdOrElseThrow(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public StockDTO replace(StockDTO dto) {
        Optional<Stock> stockOptional = repository.findById(dto.getId());
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setName(dto.getName());
            stock.setPrice(dto.getPrice());
            stock.setVariation(dto.getVariation());
            stock.setDate(dto.getDate());
            return mapper.toDTO(repository.save(stock));
        }
        throw new NoSuchElementException();
    }
}
