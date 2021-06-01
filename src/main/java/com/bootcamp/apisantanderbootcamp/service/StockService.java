package com.bootcamp.apisantanderbootcamp.service;

import com.bootcamp.apisantanderbootcamp.dto.StockDTO;
import com.bootcamp.apisantanderbootcamp.entity.Stock;
import com.bootcamp.apisantanderbootcamp.exceptions.StockAlreadyRegisteredException;
import com.bootcamp.apisantanderbootcamp.mapper.StockMapper;
import com.bootcamp.apisantanderbootcamp.repository.StockRepository;
import com.bootcamp.apisantanderbootcamp.utils.MessageUtils;
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
    public StockDTO save(StockDTO dto) throws StockAlreadyRegisteredException {
        Optional<Stock> stockAlreadyExist = repository.findByNameAndAndDate(dto.getName(), dto.getDate());
        if(stockAlreadyExist.isPresent()) {
            throw new StockAlreadyRegisteredException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
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
    public StockDTO replace(StockDTO dto) throws StockAlreadyRegisteredException {
        Optional<Stock> byStockAndUpdate = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if (byStockAndUpdate.isPresent()) {
            throw new StockAlreadyRegisteredException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        stock.setId(dto.getId());
        repository.save(stock);
        return mapper.toDTO(stock);
    }
}
