
import java.util.ArrayList;
import java.util.Map;

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
    
    public Trade parseBtcChinaTrade(String tradeString) {
        if (tradeString.length() > 1) {
            String[] parts = tradeString.split("\"");
            String price = parts[11];
            String amount = parts[3];
            long date = (long) System.currentTimeMillis() * 1000;
            Trade trade = new Trade(Double.parseDouble(price), Double.parseDouble(amount), date);
            return trade;
        } else {
            return null;
        }
    }

}
