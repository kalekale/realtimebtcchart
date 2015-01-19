
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kallelehikoinen
 */
public interface MarketClient {
    
    ArrayList<Trade> trades = new ArrayList();
    
    ArrayList<Trade> TradesForPrevious(long start, long end);
    void addTrade(Trade trade);
    
}
