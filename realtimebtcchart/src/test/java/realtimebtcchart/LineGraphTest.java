/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kalekale
 */
public class LineGraphTest {

    BtcChina chn2 = new BtcChina();
    Statistics stat = new Statistics(chn2);
    LineGraph graph = new LineGraph(stat);
    Trade t0 = new Trade(1.1, 1.0, 8);
    Trade t1 = new Trade(1.5, 1.0, 9);
    Trade t2 = new Trade(1.2, 1.0, 10);
    Trade t3 = new Trade(1.3, 1.0, 11);
    Trade t4 = new Trade(1.4, 1.0, 12);

    public LineGraphTest() {
        chn2.addTrade(t0);
        chn2.addTrade(t1);
        chn2.addTrade(t2);
        chn2.addTrade(t3);
        chn2.addTrade(t4);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void update1() {
        graph.update(9);
        assertTrue(graph.lines.size() == 2);
    }
    
    @Test
    public void update2() {
        graph.update(9);
        graph.update(10);
        graph.update(11);
        graph.update(12);
        
        assertTrue(graph.lines.size() == 5);
    }
}
