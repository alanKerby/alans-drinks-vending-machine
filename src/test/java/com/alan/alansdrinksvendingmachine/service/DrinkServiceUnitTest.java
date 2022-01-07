package com.alan.alansdrinksvendingmachine.service;

import com.alan.alansdrinksvendingmachine.domain.Drink;
import com.alan.alansdrinksvendingmachine.repo.DrinkRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DrinkServiceUnitTest {

    @Autowired
    private DrinkService drinkService;

    @MockBean
    private DrinkRepo drinkRepo;

    @Test
    public void createTest() {
        Drink input = new Drink("Odd Coffee", 30, 30, 8, 20, false, true, 20);
        Drink output = new Drink(1L, "Odd Coffee", 30, 30, 8, 20, false, true, 20);
        Mockito.when(this.drinkRepo.save(input)).thenReturn(output);
        Assertions.assertEquals(output, this.drinkService.create(input));
        Mockito.verify(this.drinkRepo, Mockito.times(1)).save(input);
    }

    @Test
    public void readAllTest() {
        Drink in1 = new Drink(1L,"Odd Coffee", 30, 30, 8, 20, false, true, 20);
        Drink in2 = new Drink(2L, "hoffee Coffee", 20, 35, 16, 10, true, false, 10);
        List<Drink> input = Arrays.asList(in1, in2);
        List<Drink> output = new ArrayList<>(input);
        Mockito.when(this.drinkRepo.findAll()).thenReturn(output);
        Assertions.assertEquals(output, this.drinkService.readAll());
        Mockito.verify(this.drinkRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void readByIDTest() {
        long input = 1L;
        Drink output = new Drink(1L, "Odd Coffee", 30, 30, 8, 20, false, true, 20);
        Mockito.when(this.drinkRepo.findById(input)).thenReturn(java.util.Optional.of(output));
        Assertions.assertEquals(output, this.drinkService.readByID(input));
        Mockito.verify(this.drinkRepo, Mockito.times(1)).findById(input);
    }

    @Test
    public void updateByID() {
        long longInput = 1L;
        Drink drinkWithChanges = new Drink(1L, "Updated Odd Coffee", 30, 30, 8, 20, false, true, 20);
        Drink drinkToUpdate = new Drink(1L, "Odd Coffee", 30, 30, 8, 20, false, true, 20);
        Mockito.when(this.drinkRepo.findById(longInput)).thenReturn(java.util.Optional.of(drinkToUpdate));
        Mockito.when(this.drinkRepo.saveAndFlush(drinkWithChanges)).thenReturn(drinkWithChanges);
        Assertions.assertEquals(drinkWithChanges, this.drinkService.updateByID(longInput, drinkWithChanges));
        Mockito.verify(this.drinkRepo, Mockito.times(1)).findById(longInput);
        Mockito.verify(this.drinkRepo, Mockito.times(1)).saveAndFlush(drinkWithChanges);
    }

    @Test
    public void deleteByIDTest() {
        long id = 1L;
        Mockito.when(this.drinkRepo.existsById(id)).thenReturn(false);
        Assertions.assertTrue(this.drinkService.deleteByID(id));
        Mockito.verify(this.drinkRepo, Mockito.times(1)).deleteById(id);
        Mockito.verify(this.drinkRepo, Mockito.times(1)).existsById(id);
    }
}
