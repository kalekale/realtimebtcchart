/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package realtimebtcchart.datavisualization;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import realtimebtcchart.dataproccessing.BtcChina;
import realtimebtcchart.dataproccessing.Statistics;
import realtimebtcchart.dataproccessing.Trade;
import realtimebtcchart.datavisualization.CandlestickGraph;
import realtimebtcchart.datavisualization.LineGraph;

/**
 *
 * @author kallelehikoinen
 */
public class CandlestickGraphTest {
     BtcChina chn2;
    Statistics stat;
    CandlestickGraph graph;
    Trade t0 = new Trade(1.1, 1.0, 8);
    Trade t1 = new Trade(1.5, 1.0, 9);
    Trade t2 = new Trade(1.2, 1.0, 10);
    Trade t3 = new Trade(1.3, 1.0, 11);
    Trade t4 = new Trade(1.4, 1.0, 12);
    
    public CandlestickGraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        chn2 = new BtcChina();
        stat = new Statistics(chn2);
        graph = new CandlestickGraph(stat);

        chn2.addTrade(t0);
        chn2.addTrade(t1);
        chn2.addTrade(t2);
        chn2.addTrade(t3);
        chn2.addTrade(t4);
    }
    @Test
    public void update1() {
        graph.update(9);
        
        assertTrue(graph.getParts().size() == 2);
    }

    @Test
    public void update2() {
        graph.update(9);
        graph.update(10);
        graph.update(11);
        graph.update(12);

        assertTrue(graph.getParts().size() == 5);
    }

    @Test
    public void getFirstYTest() {
        graph.update(12);
        assertTrue(graph.getFirstY() == 110);
    }

    @Test
    public void getLastXTest() {
        graph.update(13);
        System.out.println("last x " + graph.getLastX());
        assertTrue(graph.getLastX() == 1);
    }

    @Test
    public void getLastXTest1() {
        graph.update(9);
        graph.update(11);
        System.out.println("last x " + graph.getLastX());
        assertTrue(graph.getLastX() == 2);
    }

    @Test
    public void getPartsTest() {
        graph.update(9);
        graph.update(10);
        graph.update(11);
        graph.update(12);
        assertTrue(graph.getParts().size() == 5);
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
