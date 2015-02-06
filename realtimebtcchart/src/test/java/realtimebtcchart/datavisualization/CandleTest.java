/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart.datavisualization;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.DebugGraphics;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import realtimebtcchart.dataproccessing.BtcChina;
import realtimebtcchart.dataproccessing.Statistics;

/**
 *
 * @author kallelehikoinen
 */
public class CandleTest {

    Candle rising;
    Candle falling;
    Candle noAction;
    GraphSurface gs = new GraphSurface(new CandlestickGraph(new Statistics(new BtcChina())));

    public CandleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        JFrame jframe = new JFrame();
        jframe.add(gs);
        jframe.setVisible(true);
        gs.setVisible(true);
        rising = new Candle(1, 5, 6, 0, 1);
        falling = new Candle(5, 1, 5, 0, 2);
        noAction = new Candle(1, 1, 1, 1, 3);
    }

    @Test
    public void risingAction() {
        assertTrue(rising.priceAction.equals(PriceAction.RISING));
    }

    @Test
    public void fallingAction() {
        assertTrue(falling.priceAction.equals(PriceAction.FALLING));
    }

    @Test
    public void noAction() {
        assertTrue(noAction.priceAction.equals(PriceAction.NOACTION));
    }

    @Test
    public void drawRisingTest() {
        Graphics g = gs.getGraphics();
        rising.draw(g, 0, 0);
        assertTrue(g.getColor().equals(Color.GREEN));
    }

    @Test
    public void drawFallingTest() {
        Graphics g = gs.getGraphics();
        falling.draw(g, 0, 0);
        assertTrue(g.getColor().equals(Color.RED));
    }

    @Test
    public void drawNoActionTest() {
        Graphics g = gs.getGraphics();
        noAction.draw(g, 0, 0);
        assertTrue(g.getColor().equals(Color.BLACK));
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
