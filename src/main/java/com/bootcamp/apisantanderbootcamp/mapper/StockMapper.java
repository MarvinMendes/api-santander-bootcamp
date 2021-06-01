package com.bootcamp.apisantanderbootcamp.mapper;

import com.bootcamp.apisantanderbootcamp.dto.StockDTO;
import com.bootcamp.apisantanderbootcamp.entity.Stock;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class StockMapper {

     public StockDTO toDTO(Stock stock) {
          StockDTO stockDTO = new StockDTO();
          stockDTO.setId(stock.getId());
          stockDTO.setName(stock.getName());
          stockDTO.setPrice(stock.getPrice());
          stockDTO.setVariation(stock.getVariation());
          stockDTO.setDate(stock.getDate());
          return stockDTO;
     }
     public Stock toEntity(StockDTO dto) {
          Stock stock = new Stock();
          stock.setName(dto.getName());
          stock.setPrice(dto.getPrice());
          stock.setVariation(dto.getVariation());
          stock.setDate(dto.getDate());
          return stock;
     }

     public List<StockDTO> toDTO(List<Stock> list) {
          return list.stream().map(this::toDTO).collect(Collectors.toList());
     }

}
