package com.qacart.todo.APIRequest;

import com.qacart.todo.data.Route;
import com.qacart.todo.models.Todo;
import com.qacart.todo.models.User;
import groovyjarjarantlr4.runtime.Token;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodoApi {
    public  static Response addtodo (Todo todo, String token){
        return given().baseUri(Route.REG_ROUTE)
                .body(todo) .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().post(Route.TODO_ROUTE)
                .then().log().all().
                extract().response();
    }
    public  static Response deletetodo (Todo todo, String token){
        return given().baseUri(Route.REG_ROUTE)
                .body(todo) .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().delete(Route.TODO_ROUTE)
                .then().log().all().
                extract().response();
    }

    public static Response gettodo (String ID, String token){
        return given().baseUri(Route.REG_ROUTE)
                .auth().oauth2(token)
                .when().get(Route.TODO_ROUTE+"/"+ID)
                .then().log().all().extract().response();
    }
}
