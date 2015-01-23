/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class StatisticsTest {

    BtcChina chn = new BtcChina();
    Statistics stat = new Statistics(chn);
    Trade t0 = new Trade(1.1, 1.0, 8);
    Trade t1 = new Trade(1.5, 1.0, 9);
    Trade t2 = new Trade(1.2, 1.0, 10);
    Trade t3 = new Trade(1.3, 1.0, 11);
    Trade t4 = new Trade(1.4, 1.0, 12);
    

    public StatisticsTest() {
        chn.addTrade(t0);
        chn.addTrade(t1);
        chn.addTrade(t2);
        chn.addTrade(t3);
        chn.addTrade(t4);
    }

    @Test
    public void higestTest1() {
        double highest = stat.highest(10, 13);
        assertTrue(highest == 1.4);
    }
    
    @Test
    public void higestTest2() {
        double highest = stat.highest(9, 13);
        assertTrue(highest == 1.5);
    }
    
    @Test
    public void lowestTest1() {
        double lowest = stat.lowest(10, 13);
        assertTrue(lowest == 1.2);
    }
    
    @Test
    public void lowestTest2() {
        double lowest = stat.lowest(8, 13);
        assertTrue(lowest == 1.1);
    }
    
    @Test
    public void openTest1() {
        double open = stat.open(8, 13);
        assertTrue(open == 1.1);
    }
    
    @Test
    public void openTest2() {
        double open = stat.open(9, 11);
        assertTrue(open == 1.5);
    }
    
     @Test
    public void closeTest1() {
        double close = stat.close(8, 13);
        assertTrue(close == 1.4);
    }
    
    @Test
    public void closeTest2() {
        double close = stat.close(9, 11);
        assertTrue(close == 1.2);
    }
    
}
