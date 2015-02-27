package realtimebtcchart.dataproccessing;

import realtimebtcchart.dataproccessing.Trade;
import java.util.ArrayList;

/**
 * Turns Trades into data which is used to draw graphs.
 *
 * @author kallelehikoinen
 */
public class Statistics {

    private MarketClient client;

    public Statistics(MarketClient client) {
        this.client = client;
    }

    /**
     * Returns highest price for selected time interval
     *
     * @param start time interval beginning
     * @param end time interval end
     *
     * @return highest
     */
    public double highest(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);
        double highest = 0;
        for (Trade t : trades) {
            if (t.getPrice() > highest) {
                highest = t.getPrice();
            }
        }
        return highest;
    }

    public long firstTrade() {
        long earliest = Integer.MAX_VALUE;
        ArrayList<Trade> trades = client.TradesForPrevious(0, System.currentTimeMillis());
        for (Trade t : trades) {
            if (t.getDate() < earliest) {
                earliest = t.getDate();
            }
        }
        return earliest;
    }

    /**
     * Returns lowest price for selected time interval
     *
     * @param start time interval beginning
     * @param end time interval end
     *
     * @return lowest
     */
    public double lowest(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);
        double lowest = Integer.MAX_VALUE;
        for (Trade t : trades) {
            if (t.getPrice() < lowest) {
                lowest = t.getPrice();
            }
        }
        return lowest;
    }

    /**
     * Returns first price for selected time interval
     *
     * @param start time interval beginning
     * @param end time interval end
     *
     * @return open
     */
    public double open(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);
        long firstDate = Long.MAX_VALUE;
        double open = 0;
        for (Trade t : trades) {
            System.out.println(t);
            if (t.getDate() < firstDate) {
                open = t.getPrice();
                firstDate = t.getDate();
            }
        }
        System.out.println("start: " + start + " end: " + end + " open: " + open);
        return open;
    }

    /**
     * Returns last price for selected time interval
     *
     * @param start time interval beginning
     * @param end time interval end
     *
     * @return close
     */
    public double close(long start, long end) {
        ArrayList<Trade> trades = client.TradesForPrevious(start, end);

        long lastDate = 0;
        double close = 0;
        for (Trade t : trades) {
            if (t.getDate() > lastDate) {
                close = t.getPrice();
                lastDate = t.getDate();
            }
        }
        return close;
    }

}
