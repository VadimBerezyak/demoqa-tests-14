package com.demoqa.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomStringFromStas(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomStringAlternative(int length) {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@qa.guru";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomMobile(){
        return getRandomLong(1111111111L, 9999999999L) + "";
    }

}



