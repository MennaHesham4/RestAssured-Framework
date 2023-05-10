package com.qacart.todo.APIRequest;

import com.qacart.todo.data.Route;
import com.qacart.todo.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {
    public static Response register(User user){
       return given().baseUri(Route.REG_ROUTE).contentType(ContentType.JSON)//content type created automatic at postman
                .body(user).when().post("api/v1/users/register")
                .then().log().all()
                .extract().response();
    }
    public static Response login (User user) {
       return given().baseUri(Route.REG_ROUTE).contentType(ContentType.JSON)//content type created automatic at postman
            .body(user).when().post(Route.login_route)
            .then().log().all()
            .extract().response();}
}
