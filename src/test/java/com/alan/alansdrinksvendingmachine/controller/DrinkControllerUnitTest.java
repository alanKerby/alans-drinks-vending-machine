package com.alan.alansdrinksvendingmachine.controller;

import com.alan.alansdrinksvendingmachine.domain.Drink;
import com.alan.alansdrinksvendingmachine.service.DrinkService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest

public class DrinkControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DrinkService drinkService;

    @Test
    public void createDrinkTest() throws Exception {
        Drink drinkToCreate = new Drink("another coffee", 60, 0, 8, 30, true, false, 6);
        String entryAsJSON = this.objectMapper.writeValueAsString(drinkToCreate);
        Mockito.when(this.drinkService.create(drinkToCreate)).thenReturn(drinkToCreate);
        mockMvc.perform(post("/alans-drinks-vending-machine/create-drink")
                .contentType(MediaType.APPLICATION_JSON)
                .content(entryAsJSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(entryAsJSON));
    }

    @Test
    public void readAllDrinksTest() throws Exception {
        Drink drink1 = new Drink(5L, "another coffee", 60, 0, 8, 30, true, false, 6);
        Drink drink2 = new Drink(8L, "yet another coffee", 40, 0, 8, 30, true, false, 6);
        List<Drink> drinksInDatabase = Arrays.asList(drink1, drink2);
        String entryAsJSON = this.objectMapper.writeValueAsString(drinksInDatabase);
        Mockito.when(this.drinkService.readAll()).thenReturn(drinksInDatabase);
        mockMvc.perform(get("/alans-drinks-vending-machine/read-all-drinks"))
                .andExpect(status().isOk())
                .andExpect(content().json(entryAsJSON));
    }

    @Test
    public void readDrinkByIDTest() throws Exception {
        long id = 5L;
        Drink drinkInDatabase = new Drink(5L, "another coffee", 60, 0, 8, 30, true, false, 6);
        String entryAsJSON = this.objectMapper.writeValueAsString(drinkInDatabase);
        Mockito.when(this.drinkService.readByID(id)).thenReturn(drinkInDatabase);
        mockMvc.perform(get("/alans-drinks-vending-machine/read-drink-by-id/" + id))
                .andExpect(status().isFound())
                .andExpect(content().json(entryAsJSON));
    }

    @Test
    public void updateDrinkByIDTest() throws Exception {
        long id = 5L;
        Drink drinkWithChanges = new Drink(5L, "another coffee", 60, 0, 8, 30, true, false, 6);
        String drinkWithChangesAsJSON = this.objectMapper.writeValueAsString(drinkWithChanges);
        Mockito.when(this.drinkService.updateByID(id, drinkWithChanges)).thenReturn(drinkWithChanges);
        mockMvc.perform(put("/alans-drinks-vending-machine/update-drink-by-id/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(drinkWithChangesAsJSON))
                .andExpect(status().isAccepted())
                .andExpect(content().json(drinkWithChangesAsJSON));
    }

    @Test
    public void deleteDrinkByIDTest() throws Exception {
        long id = 5L;
        Mockito.when(this.drinkService.deleteByID(id)).thenReturn(true);
        mockMvc.perform(delete("/alans-drinks-vending-machine/delete-drink-by-id/" + id))
                .andExpect(status().isAccepted())
                .andExpect(content().string("true"));
    }
}
