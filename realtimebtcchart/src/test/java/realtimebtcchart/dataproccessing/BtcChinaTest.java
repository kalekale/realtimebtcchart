package realtimebtcchart.dataproccessing;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import realtimebtcchart.dataproccessing.Trade;
import realtimebtcchart.dataproccessing.BtcChina;
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
public class BtcChinaTest {
    
    public BtcChinaTest(){
    }

    BtcChina chn1 = new BtcChina();
    Trade t1 = new Trade(1.2, 1.0, 9);
    Trade t2 = new Trade(1.2, 1.0, 10);
    Trade t3 = new Trade(1.2, 1.0, 11);
    Trade t4 = new Trade(1.2, 1.0, 12);

    @Before
    public void setUp() {
        chn1.emptyList();
    }

    @Test
    public void addOneTradeTest() {
        chn1.addTrade(t1);
        assertTrue(chn1.allTrades().size() == 1);
    }

    @Test
    public void addTwoTradesTest() {
        chn1.addTrade(t1);
        chn1.addTrade(t2);
        assertTrue(chn1.allTrades().size() == 2);
    }

    @Test
    public void TradesForPreviousTest1() {
        chn1.addTrade(t1);
        chn1.addTrade(t2);
        chn1.addTrade(t3);
        chn1.addTrade(t4);
        assertTrue(chn1.TradesForPrevious(10, 12).size() == 2);
    }

    @Test
    public void TradesForPreviousTest2() {
        chn1.addTrade(t1);
        chn1.addTrade(t2);
        chn1.addTrade(t3);
        chn1.addTrade(t4);
        assertTrue(chn1.TradesForPrevious(8, 9).size() == 0);
    }
}
