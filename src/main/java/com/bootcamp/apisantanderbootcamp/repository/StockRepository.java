package com.bootcamp.apisantanderbootcamp.repository;

import com.bootcamp.apisantanderbootcamp.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
