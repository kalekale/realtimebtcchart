package realtimebtcchart.dataproccessing;

import realtimebtcchart.dataproccessing.Trade;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Parses the data from MarketClient into trades
 *
 * @author kallelehikoinen
 */
public class Parser {

    public Parser() {
    }

    /**
     * Parses JSONObject into Trade
     *
     * @param json JsonObject to parse
     *
     * @return trade
     */
    public Trade parseBtcChinaTrade(JSONObject json) {
        try {
            String price = json.getString("price");
            String amount = json.getString("amount");
            long date = (long) System.currentTimeMillis();
            Trade trade = new Trade(Double.parseDouble(price), Double.parseDouble(amount), date);
            return trade;
        } catch (JSONException ex) {
            return null;
        }

    }

}
