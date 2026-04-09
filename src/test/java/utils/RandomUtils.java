package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public static void main(String[] args) {
    System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomAddress());
        System.out.println(getRandomInt(111, 999999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
    }

    public static String getRandomString(int len) {
        //String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@gmail.com";
    }

    public static String getRandomAddress() {
        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone () {
       return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
               getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }
//рандом пола из массива значений (потом на скопировать на хобби и будет работать)
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemArray(genders);
    }
    //обработка массива значений (сейчас используется в связке с полом, но можно и другие массивы)
    public static String getRandomItemArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];

    }
}
