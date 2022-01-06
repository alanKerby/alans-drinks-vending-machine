package com.alan.alansdrinksvendingmachine.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    public void noIdConstructor() {
        Drink drink = new Drink("Odd Coffee", 30, 30, 8, 20, false, true, 20);
        Assertions.assertNotNull(drink.getName());
        Assertions.assertEquals(drink.getName(), "Odd Coffee");
        Assertions.assertEquals(drink.getCoffeeBeansGrams(), 8);
        Assertions.assertEquals(drink.getHotWaterML(), 30);
        Assertions.assertEquals(drink.getIceWaterMl(), 30);
        Assertions.assertEquals(drink.getMilkML(), 20);
        Assertions.assertEquals(drink.getSugarSyrupMl(), 20);
        Assertions.assertFalse(drink.isFrothedMilk());
        Assertions.assertTrue(drink.isHotMilk());
    }

    @Test
    public void Constructor() {
        Drink drink = new Drink(7L, "Odd Coffee", 30, 40, 8, 20, false, true, 20);
        Assertions.assertNotNull(drink.getId());
        Assertions.assertNotNull(drink.getName());
        Assertions.assertEquals(drink.getId(), 7L);
        Assertions.assertEquals(drink.getName(), "Odd Coffee");
        Assertions.assertEquals(drink.getCoffeeBeansGrams(), 8);
        Assertions.assertEquals(drink.getHotWaterML(), 30);
        Assertions.assertEquals(drink.getIceWaterMl(), 40);
        Assertions.assertEquals(drink.getMilkML(), 20);
        Assertions.assertEquals(drink.getSugarSyrupMl(), 20);
        Assertions.assertFalse(drink.isFrothedMilk());
        Assertions.assertTrue(drink.isHotMilk());
    }

    @Test
    void setId() {
        Drink drink = new Drink();
        drink.setId(7L);
        Assertions.assertEquals(drink.getId(), 7L);
    }

    @Test
    void getName() {
        Drink drink = new Drink();
        drink.setName("cuppajoe");
        String name =drink.getName();
        Assertions.assertEquals(name, "cuppajoe");
    }

    @Test
    void setName() {
        Drink drink = new Drink();
        drink.setName("cuppajoe");
        Assertions.assertEquals(drink.getName(), "cuppajoe");
    }

    @Test
    void setHotWaterML() {
        Drink drink = new Drink();
        drink.setHotWaterML(45);
        Assertions.assertEquals(drink.getHotWaterML(), 45);
    }

    @Test
    void getIceWaterMl() {
        Drink drink = new Drink();
        drink.setIceWaterMl(80);
        int i = drink.getIceWaterMl();
        Assertions.assertEquals(i, 80);
    }

    @Test
    void setIceWaterMl() {
        Drink drink = new Drink();
        drink.setIceWaterMl(60);
        Assertions.assertEquals(drink.getIceWaterMl(), 60);
    }

//    @Test
//    void getCoffeeBeansGrams() {
//    }

    @Test
    void setCoffeeBeansGrams() {
        Drink drink = new Drink();
        drink.setCoffeeBeansGrams(16);
        int temp = drink.getCoffeeBeansGrams();
        Assertions.assertEquals(temp, 16);
    }

//    @Test
//    void getMilkML() {
//    }

    @Test
    void setMilkML() {
        Drink drink = new Drink();
        drink.setMilkML(25);
        Assertions.assertEquals(drink.getMilkML(), 25);
    }

//    @Test
//    void isFrothedMilk() {
//    }

    @Test
    void setFrothedMilk() {
        Drink drink = new Drink();
        drink.setFrothedMilk(true);
        assertTrue(drink.isFrothedMilk());
    }

//    @Test
//    void isHotMilk() {
//    }

    @Test
    void setHotMilk() {
        Drink drink = new Drink();
        drink.setHotMilk(true);
        assertTrue(drink.isHotMilk());
    }

//    @Test
//    void getSugarSyrupMl() {
//        Drink drink = new Drink();
//        drink.setSugarSyrupMl(25);
//        Assertions.assertEquals(drink.getSugarSyrupMl(), 25);
//    }

    @Test
    void setSugarSyrupMl() {
        Drink drink = new Drink();
        drink.setSugarSyrupMl(25);
        Assertions.assertEquals(drink.getSugarSyrupMl(), 25);

    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
    }
}