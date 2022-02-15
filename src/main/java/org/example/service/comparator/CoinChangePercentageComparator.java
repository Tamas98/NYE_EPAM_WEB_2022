package org.example.service.comparator;

import org.example.domain.coin.Coin;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class CoinChangePercentageComparator implements Comparator<Coin> {

    @Override
    public int compare(Coin o1, Coin o2) {
        return Float.compare(o2.getPriceChangePercent(), o1.getPriceChangePercent());
    }
}
