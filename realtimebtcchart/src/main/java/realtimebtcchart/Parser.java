package realtimebtcchart;


import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kallelehikoinen
 */
public class Parser {

    public Parser() {
    }

    ;
    
    public Trade parseBtcChinaTrade(JSONObject json) {
        try {
            String price = json.getString("price");
            String amount = json.getString("amount");
            
            long date = (long) System.currentTimeMillis();
            Trade trade = new Trade(Double.parseDouble(price), Double.parseDouble(amount), date);
            return trade;
        } catch (JSONException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    }

}
