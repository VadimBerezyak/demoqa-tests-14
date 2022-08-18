package com.demoqa.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomStringFromStas(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
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
        int value = ran.nextInt(array.length);
        for (int i = 0; i < array.length; i++) {
            if (value == i) {
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
        return getRandomStringFromArray(new String[]{"English", "Chemistry", "Computer Science", "Arts", "History", "Maths",
                "Accounting", "Social Studies", "Social Studies", "Physics", "Biology", "Hindi", "Economics", "Civics"});
    }

    public static String getRandomAddress() {
        return getRandomStringFromStas(100);
    }

    public static String getRandomState() {
        return getRandomStringFromArray(new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"});
    }

    public static String getRandomCityFromState(String state) {
        String city = "";
        switch (state) {
            case "NCR":
                city = getRandomStringFromArray(new String[]{"Delhi", "Gurgaon", "Noida"});
                break;
            case "Uttar Pradesh":
                city = getRandomStringFromArray(new String[]{"Agra", "Lucknow", "Merrut"});
                break;
            case "Haryana":
                city = getRandomStringFromArray(new String[]{"Karnal", "Panipat"});
                break;
            case "Rajasthan":
                city = getRandomStringFromArray(new String[]{"Jaipur", "Jaiselmer"});
                break;
            default:
                break;
        }
        return city;
    }

    public static String getRandomYearOfBirth() {
        return getRandomLong(1900L, 2100L) + "";
    }

    public static String getRandomMonthOfBirth() {
        return getRandomStringFromArray(new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
    }

    public static String getRandomDayOfBirth(String month, String year) {

        String randomDay = "";
        String[] monthWith31days = new String[]{"January", "March", "May",
                "July", "August", "October", "December"};
        String[] monthWith30days = new String[]{"April", "June",
                "September", "November"};
        String[] arr = new String[]{"John", "Mark", "Joe", "Bill", "Connor"};
        //
        if (month.equals("February")) {

            if (Integer.parseInt(year) % 4 == 0 && !(Integer.parseInt(year) % 400 == 0)) {
                randomDay = getRandomLong(1L, 28L) + "";
            } else {
                randomDay = getRandomLong(1L, 29L) + "";
            }
        } else {

            for (String x : monthWith30days) {
                if (x.equals(month)) {
                    randomDay = getRandomLong(1L, 30L) + "";
                    break;
                }
            }
            for (String y : monthWith31days) {
                if (y.equals(month)) {
                    randomDay = getRandomLong(1L, 31L) + "";
                    break;
                }
            }

        }
        if (Integer.parseInt(randomDay) < 10) {
            randomDay = "0" + randomDay;
        }
        return randomDay;
    }
}

