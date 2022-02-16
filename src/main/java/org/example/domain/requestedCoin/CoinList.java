package org.example.domain.requestedCoin;

import java.util.ArrayList;
import java.util.List;

public class CoinList {

    private static CoinList instance = null;

    private List<RequestedCoin> requestedCoinList;

    private CoinList() {
        this.requestedCoinList = new ArrayList<>();
    }

    private CoinList(List<RequestedCoin> requestedCoinList) {
        this.requestedCoinList = requestedCoinList;
    }

    public static CoinList getInstance(List<RequestedCoin> requestedCoinList) {
        if(instance == null) {
            instance = new CoinList(requestedCoinList);
        } else {
            instance.setCoinList(requestedCoinList);
        }

        return instance;
    }

    public static CoinList getInstance() {
        if(instance == null) {
            instance = new CoinList();
        }

        return instance;
    }

    public List<RequestedCoin> getCoinList() {
        return requestedCoinList;
    }

    private void setCoinList(List<RequestedCoin> requestedCoinList) {
        this.requestedCoinList = requestedCoinList;
    }
}
