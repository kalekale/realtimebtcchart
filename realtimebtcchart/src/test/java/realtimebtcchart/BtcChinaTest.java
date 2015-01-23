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
public class BtcChinaTest {
    
    public BtcChinaTest(){
    }

    BtcChina chn = new BtcChina();
    Trade t1 = new Trade(0.8, 1.0, 9);
    Trade t2 = new Trade(0.8, 1.0, 10);
    Trade t3 = new Trade(0.8, 1.0, 11);
    Trade t4 = new Trade(0.8, 1.0, 12);

    @Before
    public void setUp() {
        chn.emptyList();
    }

    @Test
    public void addOneTradeTest() {
        chn.addTrade(t1);
        assertTrue(chn.allTrades().size() == 1);
    }

    @Test
    public void addTwoTradesTest() {
        chn.addTrade(t1);
        chn.addTrade(t2);
        assertTrue(chn.allTrades().size() == 2);
    }

    @Test
    public void TradesForPreviousTest1() {
        chn.addTrade(t1);
        chn.addTrade(t2);
        chn.addTrade(t3);
        chn.addTrade(t4);
        assertTrue(chn.TradesForPrevious(10, 12).size() == 2);
    }

    @Test
    public void TradesForPreviousTest2() {
        chn.addTrade(t1);
        chn.addTrade(t2);
        chn.addTrade(t3);
        chn.addTrade(t4);
        assertTrue(chn.TradesForPrevious(8, 9).size() == 0);
    }
}
