package com.example.activityproject;

public class Menu {
    private String name;
    private String value;

    public String getName(){
        return name;
    }
    public String getValue(){
        return value;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String MenutoString(){
        return  "User: " + name + " - " + value;
    }
}
