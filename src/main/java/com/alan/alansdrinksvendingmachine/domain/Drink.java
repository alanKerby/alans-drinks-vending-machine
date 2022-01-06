package com.alan.alansdrinksvendingmachine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drink {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The drink must have a name")
    private String name;
    private int hotWaterML;
    private int iceWaterMl;
    private int coffeeBeansGrams;
    private int milkML;
    private boolean frothedMilk;
    private boolean hotMilk;
    private int sugarSyrupMl;

//    public Drink(Long id, String name, int hotWaterML, int iceWaterMl, int coffeeBeansGrams, int milkML, boolean frothedMilk, boolean hotMilk, int sugarSyrupMl) {
//        this.id = id;
//        this.name = name;
//        this.hotWaterML = hotWaterML;
//        this.iceWaterMl = iceWaterMl;
//        this.coffeeBeansGrams = coffeeBeansGrams;
//        this.milkML = milkML;
//        this.frothedMilk = frothedMilk;
//        this.hotMilk = hotMilk;
//        this.sugarSyrupMl = sugarSyrupMl;
//    }
//
//    public Drink(String name, int hotWaterML, int iceWaterMl, int coffeeBeansGrams, int milkML, boolean frothedMilk, boolean hotMilk, int sugarSyrupMl) {
//        this.name = name;
//        this.hotWaterML = hotWaterML;
//        this.iceWaterMl = iceWaterMl;
//        this.coffeeBeansGrams = coffeeBeansGrams;
//        this.milkML = milkML;
//        this.frothedMilk = frothedMilk;
//        this.hotMilk = hotMilk;
//        this.sugarSyrupMl = sugarSyrupMl;
//    }

    public Drink() {

    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHotWaterML() {
        return hotWaterML;
    }

    public void setHotWaterML(int hotWaterML) {
        this.hotWaterML = hotWaterML;
    }

    public int getIceWaterMl() {
        return iceWaterMl;
    }

    public void setIceWaterMl(int iceWaterMl) {
        this.iceWaterMl = iceWaterMl;
    }

    public int getCoffeeBeansGrams() {
        return coffeeBeansGrams;
    }

    public void setCoffeeBeansGrams(int coffeeBeansGrams) {
        this.coffeeBeansGrams = coffeeBeansGrams;
    }

    public int getMilkML() {
        return milkML;
    }

    public void setMilkML(int milkML) {
        this.milkML = milkML;
    }

    public boolean isFrothedMilk() {
        return frothedMilk;
    }

    public void setFrothedMilk(boolean frothedMilk) {
        this.frothedMilk = frothedMilk;
    }

    public boolean isHotMilk() {
        return hotMilk;
    }

    public void setHotMilk(boolean hotMilk) {
        this.hotMilk = hotMilk;
    }

    public int getSugarSyrupMl() {
        return sugarSyrupMl;
    }

    public void setSugarSyrupMl(int sugarSyrupMl) {
        this.sugarSyrupMl = sugarSyrupMl;
    }
}
