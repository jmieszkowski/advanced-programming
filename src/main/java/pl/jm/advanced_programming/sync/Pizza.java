package pl.jm.advanced_programming.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pizza {
    String pizzaName;
    String ingredients;

    public Pizza(String pizzaName, String ingredients) {
        this.pizzaName = pizzaName;
        this.ingredients = ingredients;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
