package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {
    private Boolean isCompleted; //use Boolead instead of boolean casue jackson will add default value for it (false) , but Boolean default value is null
    @JsonProperty("_id")
    private String id;
    private String item;
    private String UserID;
    private String createdAt;
    @JsonProperty("__v")
    private String v;
    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

   public Todo (Boolean isCompleted,String item){
        this.isCompleted=isCompleted;
        this.item=item;
   }
   public Todo(){
   }
   public Todo (String item){
        this.item=item;
   }

}
