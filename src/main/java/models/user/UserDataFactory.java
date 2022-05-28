package models.user;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

import static config.ConfigManager.getConfiguration;

@Log4j2
public class UserDataFactory {
    private final Faker faker;

    public UserDataFactory() {
        faker = new Faker(new Locale(getConfiguration().fakerLocale()));
    }

    public UserModel getDefaultUser() {
        UserModel user = UserModel.builder(faker.internet().emailAddress(), faker.internet().password(5, 10))
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .dayOfBirth(faker.number().numberBetween(1, 28))
                .monthOfBirth(faker.number().numberBetween(1, 12))
                .yearOfBirth(faker.number().numberBetween(20, 30))
                .company(faker.commerce().department())
                .addressMain(faker.address().fullAddress())
                .addressSecond(faker.address().secondaryAddress())
                .city(faker.address().cityName())
                .postcode(faker.numerify("#####"))
                .additionalInfo(faker.chuckNorris().fact())
                .phone(faker.numerify("+1-###-###-####"))
                .phoneMobile(faker.phoneNumber().cellPhone())
                .state(faker.number().numberBetween(2, 10))
                .country(faker.number().numberBetween(1, 1))
                .addressAlias("My address # " + faker.number().randomNumber())
                .build();
        log.info(String.format("Created userdata: %n%s%n", user));
        return user;
    }
}
