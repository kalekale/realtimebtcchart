/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kallelehikoinen
 */
public class Trade {
    
    private double price;
    private double amount;
    private long date;
    
    public Trade(double price, double amount, long date) {
        this.amount = amount;
        this.price = price;
        this.date = date;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public long getDate() {
        return this.date;
    }
    
    @Override
    public String toString() {
        return "price: " + this.price + " date: " + date + " amount: " + this.amount;
    }
}
