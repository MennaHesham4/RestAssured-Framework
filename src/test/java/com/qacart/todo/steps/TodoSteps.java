package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.models.Todo;

public class TodoSteps {
    public static Todo createtodo(){
        Faker faker=new Faker();
        String item = faker.book().title();
        Boolean isCompleted = false;
        return  new Todo(isCompleted, item);
    }
}
