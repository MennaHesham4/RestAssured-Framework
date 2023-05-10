package com.qacart.todo.testcases;

import com.qacart.todo.APIRequest.TodoApi;
import com.qacart.todo.models.Todo;
import com.qacart.todo.steps.TodoSteps;
import com.qacart.todo.steps.UserSteps;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TodoTest {
    @Test
    public void shouldaddtodo(){
      /*  String body = "  {\n" +
                "\"isCompleted\": false, \n" +
                "\"item\" : \"Learn Appium\"\n" +
                "    }";*/
       // Todo todo=new Todo(false,"Learn Appium");
        Todo todo= TodoSteps.createtodo();
       // String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0NWFiOTI2YmQ0ZjlkMDAxNDgwZjVjMSIsImZpcnN0TmFtZSI6Ik1lbm5hIiwibGFzdE5hbWUiOiJIZXNoYW0iLCJpYXQiOjE2ODM2Njc0NDR9.Xcuujrw8Iut0qaKer3Pbw_xNpXr6zC73VeKZi3aCA2o";
        String token=UserSteps.getoken();
       Response response= TodoApi.addtodo(todo,token);
        assertThat(response.statusCode(),equalTo(201));
        assertThat(response.path("item"),equalTo("Learn Appium"));
              //  assertThat().statusCode(201)
                //.assertThat().body("item",equalTo("Learn Appium"))
                //.assertThat().body("isCompleted",equalTo(false));

        //not anyone autorized to access this feature, he must be logged in first and with his token
    }
    @Test
    public void shouldnotaddtodo(){
      /*  String body = "  {\n" +
                "\"item\" : \"Learn Appium\"\n" +
                "    }";*/
        //Todo todo=new Todo("Learn Appium") ;
        Todo todo= TodoSteps.createtodo();
        Todo learnonly= new Todo(todo.getItem());
        String token=UserSteps.getoken();
        given().baseUri("https://qacart-todo.herokuapp.com/")
                .body(learnonly) .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().post("api/v1/tasks")
                .then().log().all().
                assertThat().statusCode(400)
                .assertThat().body("item",equalTo("Learn Appium"))
                .assertThat().body("message",equalTo("\"isCompleted\" is required"));

        //not anyone autorized to access this feature, he must be logged in first and with his token
    }
    @Test
    public void shouldgettodo(){
       String  ID= "645aba2ebd4f9d001480f5c7";
        String token = UserSteps.getoken();
       Response response= TodoApi.gettodo(ID,token);

                assertThat(response.statusCode(),equalTo(200))
                assertThat(response.path("item"),equalTo("Learn Appium"))
                assertThat(response.path("isCompleted"),equalTo(false));

        //not anyone autorized to access this feature, he must be logged in first and with his token
    }
    @Test
    public void shoulddeletetodo(){
          String id = "645aba2ebd4f9d001480f5c7";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0NWFiOTI2YmQ0ZjlkMDAxNDgwZjVjMSIsImZpcnN0TmFtZSI6Ik1lbm5hIiwibGFzdE5hbWUiOiJIZXNoYW0iLCJpYXQiOjE2ODM2Njc0NDR9.Xcuujrw8Iut0qaKer3Pbw_xNpXr6zC73VeKZi3aCA2o";
        Response response = TodoApi.deletetodo(id,token);

                assertThat(response.statusCode(),equalTo(200));
                assertThat(response.path("item"),equalTo("Learn Appium"));
                assertThat(response.path("isCompleted"),equalTo(false));

        //not anyone autorized to access this feature, he must be logged in first and with his token
    }
}

//repeitation in body , base url ,  if any thing or environment change you should apdate all those places
// also test cases are dependant on each others like add id first then get todo so we cant run them prallel
//solve :use pojo class