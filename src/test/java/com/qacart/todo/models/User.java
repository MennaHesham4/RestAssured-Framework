package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
//pojo consist of private variable and settrs and getters
@JsonInclude(JsonInclude.Include.NON_NULL) //exclue any null variable didnt be set
public class User {
    private String firstName;  //must have the same name of key so jackson can deserlize it and write all keys for req and responce
    private String lastName;
    private String password;
    private String email;
    @JsonProperty("access_token") //jackson will connect properity with java variable
    private String accesstoken;
    private String userID;
    public User(){}
    //or set data by constructor
    public User (String email,String password){
        this.email=email;
        this.password=password;
    }
    public User (String firstName, String lastName, String email,String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess_token() {
        return accesstoken;
    }

    public void setAccess_token(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }



}
