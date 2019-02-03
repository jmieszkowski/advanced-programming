package pl.jm.advanced_programming.animal;

import sun.net.www.content.text.Generic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public abstract class Animal {

    protected BigInteger waterQuantity;
    protected BigInteger waterUsagePerCycle;

    protected BigInteger foodQuantity;
    protected BigInteger foodUsagePerCycle;

    protected boolean isAlive;
    protected BigDecimal weight;
    protected Sex sex;
    protected String name; // Optional

    public Animal(BigDecimal weight, Sex sex) {
        isAlive = true;
        this.weight = Objects.requireNonNull(weight, "Param [weight] cannot be null!!");
        this.sex = Objects.requireNonNull(sex, "Param [weight] cannot be null!!");
    }

    public BigInteger getWaterQuantity() {
        return waterQuantity;
    }

    public BigInteger getWaterUsagePerCycle() {
        return waterUsagePerCycle;
    }

    public BigInteger getFoodQuantity() {
        return foodQuantity;
    }

    public BigInteger getFoodUsagePerCycle() {
        return foodUsagePerCycle;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Sex getSex() {
        return sex;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setWaterQuantity(BigInteger waterQuantity) {
        this.waterQuantity = validateParam(waterQuantity);
    }

    public void setWaterUsagePerCycle(BigInteger waterUsagePerCycle) {
        this.waterUsagePerCycle = validateParam(waterUsagePerCycle);
    }

    public void setFoodQuantity(BigInteger foodQuantity) {
        this.foodQuantity = validateParam(foodQuantity);
    }

    public void setFoodUsagePerCycle(BigInteger foodUsagePerCycle) {
        this.foodUsagePerCycle = validateParam(foodUsagePerCycle);
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = validateParam(weight);
    }

    public void setName(String name) {
        this.name = name;
    }

    <T> T validateParam(T param) {
        if (param != null) return param;
        else throw new RuntimeException();

    }

    public void eatAndDrink(BigInteger drinkAmount, BigInteger foodAmount) {
        if (isAlive) {
            waterQuantity = waterQuantity.add(drinkAmount);
            foodQuantity = foodQuantity.add(foodAmount);
        }
    }

    public void consumeCalories() {
        if (isAlive) {
            waterQuantity = waterQuantity.subtract(waterUsagePerCycle);
            foodQuantity = foodQuantity.subtract(foodUsagePerCycle);
        }
        System.out.println(this.getName() + ": Water: " + waterQuantity + " Food: " + foodQuantity);
        System.out.println();
        if (waterQuantity.intValue() < 0
                || foodQuantity.intValue() < 0) {
            setAlive(false);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "waterQuantity=" + waterQuantity +
                ", waterUsagePerCycle=" + waterUsagePerCycle +
                ", foodQuantity=" + foodQuantity +
                ", foodUsagePerCycle=" + foodUsagePerCycle +
                ", isAlive=" + isAlive +
                ", weight=" + weight +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }
}
