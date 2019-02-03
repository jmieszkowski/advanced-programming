package pl.jm.advanced_programming.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Wolf extends Animal {

    protected Wolf(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }


    public static Wolf createWolfWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Wolf result = new Wolf(weight,sex);
        result.setName(name);
        return result;
    }

    public static Wolf creatWolfWithEverything(
            BigInteger waterQuantity,
            BigInteger waterUsagePerCycle,
            BigInteger foodQuantity,
            BigInteger foodUsagePerCycle,
            BigDecimal weight,
            Sex sex,
            String name){

        Wolf result =  Wolf.createWolfWithWeightAndSexAndName(weight,sex,name);
        result.setWaterQuantity(waterQuantity);
        result.setWaterUsagePerCycle(waterUsagePerCycle);
        result.setFoodQuantity(foodQuantity);
        result.setFoodUsagePerCycle(foodUsagePerCycle);

        return result;
    }



}
