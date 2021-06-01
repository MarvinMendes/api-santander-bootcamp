package com.bootcamp.apisantanderbootcamp.repository;

import com.bootcamp.apisantanderbootcamp.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndAndDate(String name, LocalDate date);
}
