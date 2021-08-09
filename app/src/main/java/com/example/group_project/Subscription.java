package com.example.group_project;

public class Subscription {
    private int SubId;
    private String SubName;
    private String Date;
    private String SubPrice;
    private String SubType;

    public Subscription() {}
    public Subscription(/*int Id,*/ String name, String date, String price, String type){
        this.Date = date;
        this.SubName = name;
        this.SubPrice = price;
        this.SubType = type;
    }

    public Subscription(String name, String date, String price) {
    }

    //setters
   public void setSubId(int id) {
        this.SubId  = id;
    }

    public void setSubName(String name){
        this.SubName = name;
    }

    public void setDate(String date){
        this.Date = date;
    }

    public void setSubPrice(String price){
        this.SubPrice = price;
    }

    public void setSubType(String type){
        this.SubType = type;
    }

    //getters
    public int getSubId() {
        return this.SubId;
    }

    public String getSubName(){
        return this.SubName;
    }

    public String getDate(){
        return this.Date;
    }

    public String getSubPrice(){
        return this.SubPrice;
    }

    public String getSubType(){
        return this.SubType;
    }


}
