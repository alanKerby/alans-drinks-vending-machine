package com.alan.alansdrinksvendingmachine.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import nl.jqno.equalsverifier.EqualsVerifier;

class DrinkUnitTest {

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
    public void setters() {
        Drink drink = new Drink();
        drink.setId(1L);
        drink.setName("hoffee coffee");
        drink.setSugarSyrupMl(20);
        drink.setHotMilk(true);
        drink.setFrothedMilk(true);
        drink.setCoffeeBeansGrams(6);
        drink.setIceWaterMl(40);
        drink.setMilkML(30);
        drink.setHotWaterML(50);
        Assertions.assertEquals(drink.getId(), 1L);
        Assertions.assertEquals(drink.getName(), "hoffee coffee");
        Assertions.assertEquals(drink.getSugarSyrupMl(),  20);
        Assertions.assertTrue(drink.isHotMilk());
        Assertions.assertTrue(drink.isFrothedMilk());
        Assertions.assertEquals(drink.getCoffeeBeansGrams(), 6);
        Assertions.assertEquals(drink.getIceWaterMl(), 40);
        Assertions.assertEquals(drink.getMilkML(), 30);
        Assertions.assertEquals(drink.getHotWaterML(), 50);

    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
    }
}