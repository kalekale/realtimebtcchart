/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart.datavisualization;

import realtimebtcchart.datavisualization.GraphPart;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * A Candle is a part of a CandlestickGraph. The candles form depends on its
 * open, close, highest and lowest values
 *
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

    /**
     * Draws the Candle on the Graphics given as param
     *
     * @param g Graphics to draw candle on
     * @param xOffset value substracted from x1
     * @param yOffset value substracted from open if priceAction is RISING and
     * from close is priceAction is FALLING
     * @param xScale multiplier for x coordinates and width
     * @param yScale multiplier for y coordinates and height
     *
     */
    @Override
    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale) {
        System.out.println("open: " + open + " close: " + close + " high: " + highest + " low: " + lowest);
        int scaledX1 = (int) ((x1 - xOrigin) * xScale);
        int scaledOpenYOffsetDifference = (int) ((open - yOrigin) * yScale);
        int scaledCloseYOffsetDifference = (int) ((close - yOrigin) * yScale);
        int scaledWidth = (int) xScale;
        int scaledHeigth = -(int) (Math.abs(open - close) * yScale);
        if (priceAction.equals(PriceAction.RISING)) {
            g2d.setColor(Color.green);
            g2d.drawRect(scaledX1, scaledCloseYOffsetDifference, scaledWidth, scaledHeigth);
        } else if (priceAction.equals(PriceAction.FALLING)) {
            g2d.setColor(Color.red);
            g2d.drawRect(scaledX1, scaledOpenYOffsetDifference, scaledWidth, scaledHeigth);
        } else {
            g2d.drawRect(scaledX1, scaledOpenYOffsetDifference, scaledWidth, 1);
        }
        int candleMiddle = (scaledX1 + (scaledWidth / 2));
        int scaledHigh = (int) ((this.highest - yOrigin) * yScale);
        int scaledLow = (int) ((this.lowest - yOrigin) * yScale);
        g2d.drawLine(candleMiddle, scaledHigh, candleMiddle, scaledLow);
    }

}
