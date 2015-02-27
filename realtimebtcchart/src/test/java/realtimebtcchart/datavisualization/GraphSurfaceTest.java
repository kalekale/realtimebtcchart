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
import org.mockito.Mockito;
import static org.mockito.Mockito.atLeastOnce;
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
    GraphSurface gs2;
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
        gs2 = new GraphSurface(graph, 100);
        JFrame jframe = new JFrame();
        jframe.add(gs);
        jframe.setVisible(true);
        gs.setVisible(true);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void drawYscaletest() {
        gs.getGraphics().setColor(Color.red);
        gs.drawYScale(gs.getGraphics());
        assertTrue(gs.getGraphics().getColor().equals(Color.BLACK));
    }
    
    @Test
    public void moveLeftTest() {
        gs.moveLeft();
        assertTrue(gs.getXOrigin()==-1);
    }
    
    @Test
    public void moveRightTest() {
        gs.moveRight();
        assertTrue(gs.getXOrigin()==1);
    }
 
    

    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
