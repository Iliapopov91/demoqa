package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import static utils.RandomUtils.getRandomInt;

public class TestData {

    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            streetAddress = faker.address().streetAddress(),
            invalidPhoneNumber = "99999999",
            randomString = getRandomString(2),
            gender = getRandomGender(),
            phoneNumber = getRandomPhone(),
            hobbies = getRandomHobbies(),
            day = getRandomDay(),
            month = getRandomMonth(),
            year = getRandomYear(),
            uploadFile = getRandomFile(),
            subjects = getRandomSubjects(),
            state = getRandomState(),
            city = getRandomCity();

    public static String getRandomString(int len) {
        //String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

//    public static String getRandomPhone () {
//        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
//                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    public String getRandomPhone() {
    long num = ThreadLocalRandom.current().nextLong(9_000_000_000L, 10_000_000_000L);
    return Long.toString(num);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemArray(genders);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemArray(hobbies);
    }

    public static String getRandomSubjects() {
        String[] subjects = {"English", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics",
                "Social Studies", "Civics"};

        return getRandomItemArray(subjects);
    }

    public String getRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public String getRandomMonth() {
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(month);
    }

    public String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1950, 2025));
    }

    public String getRandomState() {
        String[] state = new String[]{faker.options()
                .option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan")};

        return getRandomItemArray(state);
    }

    public String getRandomCity(){
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }

    public String getRandomFile(){
        return faker.options().option("123.gif", "456.gif");
    }

    //обработка массива значений
    public static String getRandomItemArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
}
