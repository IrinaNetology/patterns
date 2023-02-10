import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator () {

    }
    public static String generateDate (int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public static String  generateCity () {
        var cities = new String [] { "Майкоп", "Горно-Алтайск", "Элиста", "Уфа", "Москва", "Казань", "Санкт-Петербург", "Улан-Удэ",
                "Махачкала", "Нарьян-Мар", "Магас", "Нальчик", "Черкесск", "Анадырь", "Ханты-Мансийск", "Петрозаводск", "Екатеринбург",
                "Калуга", "Кемерово", "Киров", "Томск", "Новосибирск", "Якутск", "Тула", "Тверь", "Нижний Новгород", "Мурманск", "Магадан",
                "Липецк", "Орел", "Сыкрывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Владикавказ", "Кызыл", "Ижевск", "Абакан", "Грозный",
                "Чебоксары", "Барнаул", "Чита", "Краснодар", "Красноярск", "Петропавловск-Камчатский", "Пермь", "Владивосток", "Ставрополь",
                "Хабаровск", "Благовещенск", "Астрахань", "Агхангельск", "Белгород", "Брянск", "Омск", "Ростов-на-Дону", "Владимир", "Волгоград",
                "Вологда", "Воронеж", "Иваново", "Иркутск", "Калининград", "Кострома", "Курган", "Курск","Великий Новгород", "Пенза", "Оренбург",
                "Псков", "Салехард", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Смоленск", "Тамбов", "Тюмень", "Ульяновск", "Челябинск",
                "Ярославль", "Севастополь", "Биробиджан"};
        return cities [new Random().nextInt(cities.length)];
        }

        public static String generateName (String locale) {
        var faker = new Faker (new Locale (locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone (String locale) {
        var faker = new  Faker (new Locale (locale));
        return  faker.phoneNumber().phoneNumber();
    }

    public static UserInfo generateUser (String locale) {
        return  new UserInfo (generateCity(), generateName(locale), generatePhone(locale));
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
