package Commons;

import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();

    public static String generateFirstName(){
        return faker.name().firstName();
    }

    public static String generateLastName(){
        return faker.name().lastName();
    }

    public static String generateEmail()
    {
        return faker.internet().emailAddress();
    }
    public static String generatePassword()
    {
        String password;
        do
            {
                password = faker.internet().password(8, 16, true, true);
            }while (!password.matches(".*[!@#$%^&*()].*"));

        return password;
    }
    public static String GroupID = "92833dab-c6eb-41ac-bc8c-dbe6b35d58e3";

    public static String adminEmail = "sixolilemjikwa@gmail.com";
    public static String adminPassword = "Chicco@2010";
    }


