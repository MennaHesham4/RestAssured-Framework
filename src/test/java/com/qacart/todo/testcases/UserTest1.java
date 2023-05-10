package com.qacart.todo.testcases;

import com.qacart.todo.APIRequest.UserApi;
import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.User;
import com.qacart.todo.steps.UserSteps;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest1 {
    @Test
    public void shouldRegister() {

        //User user=new User("Menna","Hesham","hh2@example.com","M@12345678");
        User user= UserSteps.generateuser();
        Response response=UserApi.register(user);
        User returneduser = response.body().as(User.class); //after we extract responce and save it in responce obj, we deserlize responce body from json to java obj using pojo class user
        assertThat(response.statusCode(),equalTo(201));//assersion or anything related with buttom part of postman
        assertThat(returneduser.getFirstName(),equalTo(user.getFirstName()));
    }

    @Test
    public void shouldnotRegister() {
       // User user=new User("Menna","Hesham","hh@example.com","M@12345678");
           User user=UserSteps.getregestireduser();
        Response response=UserApi.register(user);
             Error error= response.body().as(Error.class);
        assertThat(response.statusCode(),equalTo(400));//assersion or anything related with buttom part of postman
        assertThat(error.getMessage(),equalTo(ErrorMessages.email_is_registered));
              //  .assertThat().statusCode(400)//assersion or anything related with buttom part of postman
               // .assertThat().body("message", equalTo("Email is already exists in the Database"));
    }

    @Test
    public void shouldlogin() {
       /* String body = "  {\n" +
                "\"email\": \"hh@example.com\", \n" +
                "\"password\" : \"M@12345678\"\n" +
                "    }";*/ //pass java obj instead of string
             /* User user=new User();
              user.setPassword("M@12345678");
              user.setEmail("hh@example.com"); //and then jackson convert java ogj to jason (serelization)*/
       // or use constructor
        User user = UserSteps.getregestireduser();
        User loginuser=new User(user.getEmail(),user.getPassword());
        //User user=new User("hh@example.com","M@12345678");
        Response response=UserApi.login(loginuser);
          User returnedusr = response.body().as(User.class);
        assertThat(response.statusCode(),equalTo(200));//assersion or anything related with buttom part of postman
        assertThat(returnedusr.getFirstName(), equalTo(user.getFirstName()));

              //  .assertThat().statusCode(200)//assersion or anything related with buttom part of postman
              // .assertThat().body("firstName", equalTo("Menna"));
        //.assertThat().body("access_token", not(equalTo(null)));
    }
}


