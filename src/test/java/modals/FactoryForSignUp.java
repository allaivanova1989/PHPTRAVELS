package modals;

import com.github.javafaker.Faker;

public class FactoryForSignUp {
    static Faker faker = new Faker();

    public static SignUp createUser() {
       return SignUp.builder()
                .name(faker.gameOfThrones().character())
                .lastName(faker.rickAndMorty().character())
                .phone("+375338765616")
                .email(faker.regexify("[A-z]{5}") + "@gmail.com")
                .password(faker.gameOfThrones().dragon())
                .build();
    }
}
