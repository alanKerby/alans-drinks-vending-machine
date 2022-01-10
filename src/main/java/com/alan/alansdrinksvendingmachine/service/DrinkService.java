package com.alan.alansdrinksvendingmachine.service;

import com.alan.alansdrinksvendingmachine.domain.Drink;
import com.alan.alansdrinksvendingmachine.exception.NoSuchIDException;
import com.alan.alansdrinksvendingmachine.repo.DrinkRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService implements CRUD<Drink> {

    private final DrinkRepo repo;

    public DrinkService(DrinkRepo repo) {
        this.repo = repo;
    }

    @Override
    public Drink create(Drink drink) {
        return this.repo.save(drink);
    }

    @Override
    public List<Drink> readAll() {
        return this.repo.findAll();
    }

    @Override
    public Drink readByID(long id) {
        Optional<Drink> optionalDrink = this.repo.findById(id);
        return optionalDrink.orElse(null);
    }

    public Drink readByName(String name) {
        Optional<Drink> optionalDrink = Optional.ofNullable(this.repo.findDrinkByName(name));
        return optionalDrink.orElse(null);
    }

    @Override
    public Drink updateByID(long id, Drink drink) {
        Optional<Drink> optionalDrink = this.repo.findById(id);
        if (optionalDrink.isPresent()) {
            Drink temp = optionalDrink.get();
            temp.setCoffeeBeansGrams(drink.getCoffeeBeansGrams());
            temp.setFrothedMilk(drink.isFrothedMilk());
            temp.setHotMilk(drink.isHotMilk());
            temp.setHotWaterML(drink.getHotWaterML());
            temp.setIceWaterMl(drink.getIceWaterMl());
            temp.setName(drink.getName());
            temp.setSugarSyrupMl(drink.getSugarSyrupMl());
            temp.setMilkML(drink.getMilkML());
            return this.repo.saveAndFlush(temp);
        }
        return null;
    }

    @Override
    public boolean deleteByID(long id) {
        Optional<Drink> optionalDrink = this.repo.findById(id);
        if (optionalDrink.isPresent()) {
            this.repo.deleteById(id);
            return !this.repo.existsById(id);
        } else throw new NoSuchIDException("ID does not exist, please select an ID from the database");

    }
}