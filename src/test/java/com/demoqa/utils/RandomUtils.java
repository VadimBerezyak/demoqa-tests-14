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

    public static String getRandomMobile() {
        return getRandomLong(1111111111L, 9999999999L) + "";
    }

    public static String getRandomStringFromArray(String[] array) {
        Random ran = new Random();
        String randomValue = "";
        int value = ran.nextInt(array.length+1);
        for (int i = 0; i < array.length; i++) {
            if(value == i){
                randomValue = array[i];
            }
        }
        return randomValue;
    }

    public static String getRandomHobbies() {
        return getRandomStringFromArray(new String[]{"Sports", "Reading", "Music"});
    }

    public static String getRandomGender() {
        return getRandomStringFromArray(new String[]{"Male", "Female", "Other"});
    }
    public static String getRandomSubject() {
        return getRandomStringFromArray(new String[]{"English", "Chemistry","Computer Science", "Arts","History", "Maths",
                "Accounting", "Social Studies", "Social Studies","Physics","Biology","Hindi","Economics", "Civics"});
    }

}

