package com.bootcamp.apisantanderbootcamp.mapper;

import com.bootcamp.apisantanderbootcamp.dto.StockDTO;
import com.bootcamp.apisantanderbootcamp.entity.Stock;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

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

}
