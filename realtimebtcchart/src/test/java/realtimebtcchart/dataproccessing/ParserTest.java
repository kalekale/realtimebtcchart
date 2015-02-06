/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart.dataproccessing;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author kallelehikoinen
 */
public class ParserTest {

    Parser parser;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    public ParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void parseBtcChinaTradeTest1() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("price", "10");
        jo.put("amount", "100");
        Trade trade = parser.parseBtcChinaTrade(jo);
        assertTrue(trade.getAmount() == 100);
        assertTrue(trade.getPrice() == 10);
    }

    @Test
    public void parseBtcChinaTradeTest2() throws JSONException {
        JSONObject jo = new JSONObject();;
        jo.put("asd", "10");
        jo.put("qwerty", "100");
        Trade trade = parser.parseBtcChinaTrade(jo);
        assertTrue(trade == null);
    }
}
