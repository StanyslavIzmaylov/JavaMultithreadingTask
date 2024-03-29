package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
        ConsoleHelper.writeMessage(toString());
    }

    public List<Dish> getDishes() {
        return dishes;
    }
    public Tablet getTablet() {

        return tablet;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (dishes.size() == 0) return result.toString();
        result.append("Your order: [" + dishes.get(0));

        for (int i = 1; i < dishes.size(); i++) {
            result.append(", " + dishes.get(i).name());
        }
        result.append("] of " + tablet);
        result.append(", cooking time " + getTotalCookingTime() + "min");
        return result.toString();
    }
    public int getTotalCookingTime(){
        int cookingTime=0;
        for (int i = 0; i < dishes.size(); i++){
            cookingTime += dishes.get(i).getDuration();
        }
        return cookingTime;
    }
    public boolean isEmpty(){
            return dishes.isEmpty();
    }
    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
