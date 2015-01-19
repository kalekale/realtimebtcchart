
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class BtcChina implements MarketClient {

    private String postdata = "";
    private Parser parser = new Parser();

    public void connect() throws Exception {
        try {
            IO.Options opt = new IO.Options();
            opt.reconnection = true;
            Logger.getLogger(BtcChina.class.getName()).setLevel(Level.FINE);
            final Socket socket = IO.socket("https://websocket.btcchina.com", opt);

            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                BtcChina sm = new BtcChina();

                @Override
                public void call(Object... args) {
                    System.out.println("Connected!");
                    socket.emit("subscribe", "marketdata_cnybtc"); // subscribe
                }
            }).on("trade", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    JSONObject json = (JSONObject) args[0]; //receive the trade message
                    System.out.println(json.toString());
                    Trade trade = parser.parseBtcChinaTrade(json.toString());
                    trades.add(trade);
                }
            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Disconnected!");
                }
            });
            socket.connect();
        } catch (URISyntaxException ex) {
            Logger.getLogger(BtcChina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Trade> TradesForPrevious(long start, long end) {
        ArrayList<Trade> tradesSince = new ArrayList();
        for (Trade t : trades) {
            if (t.getDate() >= start && t.getDate() < end) {
                tradesSince.add(t);
            }
        }
        return tradesSince;
    }

    @Override
    public void addTrade(Trade trade) {
        trades.add(trade);
        System.out.println(trades);
    }

}
