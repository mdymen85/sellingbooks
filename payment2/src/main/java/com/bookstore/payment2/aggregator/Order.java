package com.bookstore.payment2.aggregator;

public class Order {
    
    private String type;
    private int amount;
     
    public Order(){}
     
    public Order(String type, int amount){
        this.type = type;
        this.amount = amount;
    }
     
     
    public String getType(){
        return this.type;
    }
 
    @Override
    public String toString(){
        return "Order[ type=" + this.type + " ,amount= " + this.amount + "]" ;
    }
}