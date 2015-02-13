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
import realtimebtcchart.dataproccessing.MarketClient;
import realtimebtcchart.dataproccessing.Statistics;
import realtimebtcchart.dataproccessing.Trade;

/**
 *
 * @author kallelehikoinen
 */
public class GraphSurfaceTest {
    
    GraphSurface gs;
    MarketClient chn2;
    Statistics stat;
    Graph graph;
    Trade t0 = new Trade(1.1, 1.0, 8);
    Trade t1 = new Trade(1.5, 1.0, 9);
    Trade t2 = new Trade(1.2, 1.0, 10);
    Trade t3 = new Trade(1.3, 1.0, 11);
    Trade t4 = new Trade(1.4, 1.0, 12);
    Trade t5 = new Trade(1.4, 1.0, 12);
    Trade t6 = new Trade(1.4, 1.0, 12);
    
    public GraphSurfaceTest() {
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
        graph = new CandlestickGraph (stat);
        gs = new GraphSurface(graph);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void updateYMiddleTest() {
        chn2.addTrade(t0);
        gs.update();
        assertTrue(gs.getYMiddle() == graph.getParts().get(1).getY2() / 100 * 100);
    }
    
    @Test
    public void updateYOriginTest() {
        chn2.addTrade(t0);
        gs.update();
        assertTrue(gs.getYOrigin() == (int) Math.round(gs.getYMiddle() - 5000));
    }
    
    @Test
    public void updateYscaleTest() {
        chn2.addTrade(t0);
        gs.update();
        assertTrue(gs.getYScale() == -gs.getHeight() / (double) (((gs.getYMiddle() - gs.getYOrigin()) * 2)));
    }
    
    @Test
    public void updateXscaleTest() {
        chn2.addTrade(t0);
        gs.update();
        assertTrue(gs.getXScale() == 90.0);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
