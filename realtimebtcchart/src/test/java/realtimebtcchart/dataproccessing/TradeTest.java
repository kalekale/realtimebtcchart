package realtimebtcchart.dataproccessing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import realtimebtcchart.dataproccessing.Trade;
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
public class TradeTest {
    
    @Test
    public void toStringTesti() {
        long date = 1000000000;
        double price = 1.0;
        double amount = 0.5;
        Trade trade = new Trade(price, amount, date);
        String s = trade.toString();
        assertTrue(s.equals("price: 1.0 date: 1000000000 amount: 0.5"));
    }
}
