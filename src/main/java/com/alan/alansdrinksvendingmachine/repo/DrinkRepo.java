package com.alan.alansdrinksvendingmachine.repo;

import com.alan.alansdrinksvendingmachine.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepo extends JpaRepository<Drink, Long> {
}
