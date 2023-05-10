package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.APIRequest.UserApi;
import com.qacart.todo.models.User;
import io.restassured.response.Response;

//now idont need to register first and then login (tc dependency) also avoid hardcodes steps
public class UserSteps {
    public static User generateuser(){
        Faker faker=new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email=faker.internet().emailAddress();
        String password =faker.internet().password();
        return new User(firstName,lastName,email,password);

    }
    public static User getregestireduser (){
        User user=generateuser();
        UserApi.register(user);
        return user;
    }
    public static String getoken (){
        User user=generateuser();
        Response response =UserApi.register(user);
        return response.body().path("access_token");
    }

}
