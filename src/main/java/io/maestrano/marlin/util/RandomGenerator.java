package io.maestrano.marlin.util;

import java.util.Random;

public class RandomGenerator {

    public static String generateRandomizeString(String str){
        Random rand  = new Random();
        int randInt = rand.nextInt(100000);
        randInt = randInt<10000?randInt+10000:randInt;
        return str+randInt;
    }

}
