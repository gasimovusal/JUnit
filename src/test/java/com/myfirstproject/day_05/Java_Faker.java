package com.myfirstproject.day_05;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Java_Faker {
    /* fake data = mack data => data that is not real
    fake ssn, fake ame, fake address
    we can use fake data to test
    we can use java faker class to generate fake data

    where do you get your data
    1. BA business analyst
    2. test lead
    manual tester
    4. tech lead - team teach - dev lead
     */

    // faker does not come from selenium, we have to import from meaven library
    @Test
    public void faker(){
        Faker faker = new Faker();
        // generate fake data
        String fName = faker.name().firstName();
        System.out.println(fName);
        String lName = faker.name().lastName();
        System.out.println(lName);
        String fullName = faker.name().fullName();
        System.out.println(fullName);
        String userName = faker.name().username();
        System.out.println(userName);
        String title = faker.name().title();
        System.out.println(title);
        String city = faker.address().city();
        System.out.println(city);
        String state = faker.address().state();
        System.out.println(state);
        String phoneNumber = faker.phoneNumber().cellPhone();
        System.out.println(phoneNumber);
        String email = faker.internet().emailAddress();
        System.out.println(email);
        String randomZipCode = faker.number().digits(5);
        System.out.println(randomZipCode);
        String fakeEmail = faker.name().firstName() + faker.number().digits(3)+faker.internet().emailAddress();
        System.out.println(fakeEmail);

    }
}
