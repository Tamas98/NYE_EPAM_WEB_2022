package org.example.service.comparator;

import org.example.domain.coin.Coin;

import java.util.Comparator;

public class CoinChangePercentageComparator implements Comparator<Coin> {

    @Override
    public int compare(Coin o1, Coin o2) {
        return Float.compare(o2.getPriceChangePercent(), o1.getPriceChangePercent());
    }
}
