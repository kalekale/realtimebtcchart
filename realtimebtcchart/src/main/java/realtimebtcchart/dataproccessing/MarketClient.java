package realtimebtcchart.dataproccessing;


import realtimebtcchart.dataproccessing.Trade;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * 
 * @author kallelehikoinen
 */
public interface MarketClient {
    
    ArrayList<Trade> trades = new ArrayList();
    
    ArrayList<Trade> TradesForPrevious(long start, long end);
    
    void addTrade(Trade trade);
    
    ArrayList<Trade> allTrades();
}
