/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart.datavisualization;

import realtimebtcchart.datavisualization.GraphPart;
import java.awt.Color;
import java.awt.Graphics;

/**
 * A Candle is a part of a CandlestickGraph. The candles form depends on its
 * open, close, highest and lowest values
 * @author kallelehikoinen
 */
public class Candle implements GraphPart {

    int x1;
    int open;
    int close;
    int highest;
    int lowest;
    PriceAction priceAction;

    public Candle(int open, int close, int highest, int lowest, int x1) {
        this.x1 = x1;
        this.open = open;
        this.close = close;
        this.highest = highest;
        this.lowest = lowest;
        if (open > close) {
            priceAction = PriceAction.FALLING;
        } else if (close > open) {
            priceAction = PriceAction.RISING;
        } else {
            priceAction = PriceAction.NOACTION;
        }
    }

    /**
     * Draws the Candle on the Graphics given as param
     *
     * @param g Graphics to draw candle on
     * @param xOffset value substracted from x1
     * @param yOffset value substracted from open if priceAction is RISING and 
     * from close is priceAction is FALLING
     *
     * 
     */
    
    @Override
    public void draw(Graphics g, int xOffset, int yOffset) {
        System.out.println("open " + open + " close " + close + " open-close " + (open - close) + priceAction);
        System.out.println("x1: " + x1 + " open: " + (open));
        System.out.println("y1: " + (open-yOffset));
        if (priceAction.equals(PriceAction.RISING)) {
            g.setColor(Color.green);
            g.drawRect(x1, open - yOffset, 1, Math.abs(open - close));
        } else if (priceAction.equals(PriceAction.FALLING)) {
            g.setColor(Color.red);
            g.drawRect(x1, close - yOffset, 1, Math.abs(open - close));
        } else {
            g.drawRect(x1, open - yOffset, 1, 1);
        }
    }


@Override
        public String toString() {
        return "open: " + open + " close: " + close + " x1: " + x1;
    }
    
    
    public int getX1() {
        return x1;
    }
    
    public int getOpen() {
        return open;
    }

    @Override
        public int getX2() {
        return x1;
    }

    @Override
        public int getY2() {
        return open;
    }
        
    public PriceAction getPriceAction() {
        return this.priceAction;
    }

    
    
    
        
    
    
    
    
}
