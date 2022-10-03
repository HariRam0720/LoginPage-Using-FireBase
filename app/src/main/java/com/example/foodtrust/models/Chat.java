package com.example.foodtrust.models;

public class Chat {
    String name;
    String description;
    Chat(String name,String description){
        this.name = name;
        this.description = description;
    }
    public void setName(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }
    public void setDescription(String description){
        this.description = description;

    }
    public String getDescription(){
        return description;
    }

}
