/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart.datavisualization;

import realtimebtcchart.datavisualization.Candle;
import realtimebtcchart.datavisualization.GraphPart;
import realtimebtcchart.datavisualization.Graph;
import realtimebtcchart.dataproccessing.Statistics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Class CandlestickGraph implements Graph and consists of Candles.
 *
 * @author kallelehikoinen
 */
public class CandlestickGraph implements Graph {

    ArrayList<GraphPart> candles = new ArrayList();
    long previousUpdate = 0;
    Statistics stat;

    public CandlestickGraph(Statistics stat) {
        Candle c = new Candle(0, 0, 0, 0, 0);
        candles.add(c);
        this.stat = stat;
    }

    /**
     * Creates new Candle for the time interval between lastUpdate and given
     * param
     *
     * @param tradesUntil last date in seconds to take into account
     *
     *
     *
     */
    @Override
    public void update(long tradesUntil) {
        int highest = (int) ((stat.highest(previousUpdate, tradesUntil)) * 100);
        int lowest = (int) ((stat.lowest(previousUpdate, tradesUntil)) * 100);
        int open = (int) ((stat.open(previousUpdate, tradesUntil)) * 100);
        int close = (int) ((stat.close(previousUpdate, tradesUntil)) * 100);
        int x1 = candles.size();
        candles.add(new Candle(open, close, highest, lowest, x1));
        previousUpdate = tradesUntil;
    }

    @Override
    public int getFirstY() {
        Candle c = (Candle) candles.get(1);
        return c.getOpen();
    }

    @Override
    public ArrayList<GraphPart> getParts() {
        return candles;
    }

    @Override
    public double getLastX() {
        return candles.get(candles.size() - 1).getX2();
    }

    /**
     * Draws the Candle on the Graphics given as param
     *
     * @param g Graphics to draw candle on
     * @param xOffset value substracted from Candle x1
     * @param yOffset value substracted from Candle open if priceAction is
     * RISING and from Candle close if priceAction is FALLING
     * @param xScale multiplier for Candle x coordinates and width
     * @param yScale multiplier for Candle y coordinates and height
     *
     */
    @Override
    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale) {
        for (GraphPart graphPart : candles) {
            graphPart.draw(g2d, yOrigin, xOrigin, yScale, xScale);
        }
    }

}
