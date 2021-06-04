package com.example.activityproject;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MenuResourceParser {
    private ArrayList<Menu> dishes;
    public MenuResourceParser(){
        dishes = new ArrayList<>();
    }
    public ArrayList<Menu> getDishes(){
        return dishes;
    }
    public boolean parse (XmlPullParser xpp){
        boolean status = true;
        Menu currentDish = null;
        boolean inEntry = false;
        String textValue = "";

        try{
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){

                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("dish".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentDish = new Menu();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if("dish".equalsIgnoreCase(tagName)){
                                dishes.add(currentDish);
                                inEntry = false;
                            } else if("name".equalsIgnoreCase(tagName)){
                                currentDish.setName(textValue);
                            } else if("value".equalsIgnoreCase(tagName)){
                                currentDish.setValue(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return  status;
    }
}
