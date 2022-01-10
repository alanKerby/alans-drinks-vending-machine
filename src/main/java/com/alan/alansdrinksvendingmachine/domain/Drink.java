package com.alan.alansdrinksvendingmachine.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull(message = "The drink must have a name")
    private String name;
    private int hotWaterML;
    private int iceWaterMl;
    private int coffeeBeansGrams;
    private int milkML;
    private boolean frothedMilk;
    private boolean hotMilk;
    private int sugarSyrupMl;

    public Drink(Long id, String name, int hotWaterML, int iceWaterMl, int coffeeBeansGrams, int milkML, boolean frothedMilk, boolean hotMilk, int sugarSyrupMl) {
        this.id = id;
        this.name = name;
        this.hotWaterML = hotWaterML;
        this.iceWaterMl = iceWaterMl;
        this.coffeeBeansGrams = coffeeBeansGrams;
        this.milkML = milkML;
        this.frothedMilk = frothedMilk;
        this.hotMilk = hotMilk;
        this.sugarSyrupMl = sugarSyrupMl;
    }

    public Drink(String name, int hotWaterML, int iceWaterMl, int coffeeBeansGrams, int milkML, boolean frothedMilk, boolean hotMilk, int sugarSyrupMl) {
        this.name = name;
        this.hotWaterML = hotWaterML;
        this.iceWaterMl = iceWaterMl;
        this.coffeeBeansGrams = coffeeBeansGrams;
        this.milkML = milkML;
        this.frothedMilk = frothedMilk;
        this.hotMilk = hotMilk;
        this.sugarSyrupMl = sugarSyrupMl;
    }

    public Drink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return hotWaterML == drink.hotWaterML && iceWaterMl == drink.iceWaterMl && coffeeBeansGrams == drink.coffeeBeansGrams && milkML == drink.milkML && frothedMilk == drink.frothedMilk && hotMilk == drink.hotMilk && sugarSyrupMl == drink.sugarSyrupMl && name.equals(drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hotWaterML, iceWaterMl, coffeeBeansGrams, milkML, frothedMilk, hotMilk, sugarSyrupMl);
    }
}
