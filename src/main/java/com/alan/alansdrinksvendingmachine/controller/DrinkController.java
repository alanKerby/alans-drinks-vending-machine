package com.alan.alansdrinksvendingmachine.controller;

import com.alan.alansdrinksvendingmachine.domain.Drink;
import com.alan.alansdrinksvendingmachine.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alans-drinks-vending-machine")
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    //create a drink
    @PostMapping("/create-drink")
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
        return new ResponseEntity<>(drinkService.create(drink), HttpStatus.CREATED);
    }

    //read all drinks
    @GetMapping("read-all-drinks")
    public ResponseEntity<List<Drink>> readAllDrinks() {
        return new ResponseEntity<>(drinkService.readAll(), HttpStatus.OK);
    }

    //read drink by id
    @GetMapping("read-drink-by-id/{id}")
    public ResponseEntity<Drink> findDrinkByID(@PathVariable Long id) {
        return new ResponseEntity<>(drinkService.readByID(id), HttpStatus.FOUND);
    }

    //read by name
    @GetMapping("/read-by-name/{name}")
    public ResponseEntity<Drink> readDrinkByName(@PathVariable String name) {
        return new ResponseEntity<>(this.drinkService.readByName(name),
                HttpStatus.OK);
    }

    //update a drink
    @PutMapping("update-drink-by-id/{id}")
    public ResponseEntity<Drink> updateSingleDrink(@PathVariable Long id, @RequestBody Drink drink) {
        return new ResponseEntity<>(drinkService.updateByID(id, drink), HttpStatus.ACCEPTED);
    }

    //delete drink by id
    @DeleteMapping("delete-drink-by-id/{id}")
    public ResponseEntity<Boolean> deleteSingleDrink(@PathVariable Long id) {
        return new ResponseEntity<>(drinkService.deleteByID(id), HttpStatus.ACCEPTED);
    }
}
