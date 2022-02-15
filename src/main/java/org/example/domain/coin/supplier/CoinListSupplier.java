package org.example.domain.coin.supplier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.coin.Coin;
import org.example.domain.coin.CoinList;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.function.Supplier;

public class CoinListSupplier implements Supplier<CoinList> {

    private static long lastUpdate = 0;

    @Override
    public CoinList get() {
        try {
            if(isEnoughTimeSinceLastUpdate() || lastUpdate == 0) {
                Coin[] coins = getDataFromApi();
                lastUpdate = System.currentTimeMillis();
                return CoinList.getInstance(Arrays.asList(coins));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("There was en error while fetching data from the API.");
        }
        return CoinList.getInstance();
    }

    private Coin[] getDataFromApi() throws IOException {
        URL url = new URL("https://api2.binance.com/api/v3/ticker/24hr");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        DataInputStream in = new DataInputStream(connection.getInputStream());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(in.readLine(), Coin[].class);
    }

    private boolean isEnoughTimeSinceLastUpdate() {
        return 300 < (System.currentTimeMillis() - lastUpdate) / 1000;
    }
}
