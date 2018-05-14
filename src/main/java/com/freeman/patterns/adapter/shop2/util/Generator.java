package com.freeman.patterns.adapter.shop2.util;

import java.util.Random;

public class Generator {

    public static float generatePrice(float min, float max){
        Random randomPrice = new Random();
        float result = randomPrice.nextFloat() * (max - min) + min;
        return result;
    }

    public static String generateName (int min, int max){
        Random randomName = new Random();
        int result = randomName.nextInt() * (max - min) + min;
        return "product_" + Math.abs(result);
    }
    public static int generateId (int min, int max){
        Random randomName = new Random();
        int result = randomName.nextInt() * (max - min) + min;
        return Math.abs(result);
    }
}
