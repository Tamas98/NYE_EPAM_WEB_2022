package org.example.domain.coin;

import java.util.ArrayList;
import java.util.List;

public class CoinList {

    private static CoinList instance = null;

    private List<Coin> coinList;

    private CoinList() {
        this.coinList = new ArrayList<>();
    }

    private CoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public static CoinList getInstance(List<Coin> coinList) {
        if(instance == null) {
            instance = new CoinList(coinList);
        } else {
            instance.setCoinList(coinList);
        }

        return instance;
    }

    public static CoinList getInstance() {
        if(instance == null) {
            instance = new CoinList();
        }

        return instance;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    private void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
