package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }
    private static final Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Санкт-Петербург",
                "Нижний Новгород", "Ярославль", "Екатеринбург", "Краснодар", "Кострома", "Волгоград", "Владивосток",
                "Новосибирск", "Калининград", "Белгород", "Воронеж"};
        return cities[new Random().nextInt(cities.length)];
    }
    public static String generateName(String locale) {
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
