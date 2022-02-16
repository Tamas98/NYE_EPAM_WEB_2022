package org.example.service.comparator;

import org.example.domain.requestedCoin.RequestedCoin;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class CoinChangePercentageComparator implements Comparator<RequestedCoin> {

    @Override
    public int compare(RequestedCoin o1, RequestedCoin o2) {
        return Float.compare(o2.getPriceChangePercent(), o1.getPriceChangePercent());
    }
}
