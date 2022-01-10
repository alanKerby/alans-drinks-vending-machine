package com.alan.alansdrinksvendingmachine.controller;

import com.alan.alansdrinksvendingmachine.domain.Drink;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:alans-drinks-vending-machine-schema.sql", "classpath:alans-drinks-vending-machine-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DrinkControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createDrinkIntegrationTest() throws Exception {
        Drink entry = new Drink("coffee number 2", 60, 0, 8, 30, true, false, 6);
        Drink result = new Drink(3L,"coffee number 2", 60, 0, 8, 30, true, false, 6);
        String entryAsJSON = this.objectMapper.writeValueAsString(entry);
        String resultAsJSON = this.objectMapper.writeValueAsString(result);
        mockMvc.perform(post("/alans-drinks-vending-machine/create-drink")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(entryAsJSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(resultAsJSON));
    }

    @Test
    public void readAllDrinksIntegrationTest() throws Exception {
        Drink drink1 = new Drink(1L,"H2 wakeup coffee", 60, 0, 8, 30, true, false, 6);
        Drink drink2 = new Drink(2L,"H2 wakeup coffee again", 60, 0, 8, 30, true, false, 6);
        List<Drink> drinksInDatabase = Arrays.asList(drink1, drink2);
        String drinksInDatabaseAsJSON = this.objectMapper.writeValueAsString(drinksInDatabase);
        mockMvc.perform(get("/alans-drinks-vending-machine/read-all-drinks"))
                .andExpect(status().isOk())
                .andExpect(content().json(drinksInDatabaseAsJSON));
    }

    @Test
    public void readDrinkByIDIntegrationTest() throws Exception {
        long id = 2L;
        Drink drink2 = new Drink(2L,"H2 wakeup coffee again", 60, 0, 8, 30, true, false, 6);
        String entryAsJSON = this.objectMapper.writeValueAsString(drink2);
        mockMvc.perform(get("/alans-drinks-vending-machine/read-drink-by-id/" + id))
                .andExpect(status().isFound())
                .andExpect(content().json(entryAsJSON));
    }

    @Test
    public void updateDrinkByIDIntegrationTest() throws Exception {
        long id = 2L;
        Drink drink2WithChanges = new Drink(2L,"H2 wakeup coffee again mkII", 60, 0, 8, 30, true, false, 6);
        String drinkWithChangesAsJSON = this.objectMapper.writeValueAsString(drink2WithChanges);
        mockMvc.perform(put("/alans-drinks-vending-machine/update-drink-by-id/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(drinkWithChangesAsJSON))
                .andExpect(status().isAccepted())
                .andExpect(content().json(drinkWithChangesAsJSON));
    }

    @Test
    public void deleteDrinkByIDIntegrationTest() throws Exception {
        long id = 2L;
        mockMvc.perform(delete("/alans-drinks-vending-machine/delete-drink-by-id/" + id))
                .andExpect(status().isAccepted())
                .andExpect(content().string("true"));
    }
}
