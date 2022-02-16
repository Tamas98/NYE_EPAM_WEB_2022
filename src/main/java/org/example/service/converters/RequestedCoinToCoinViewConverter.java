package org.example.service.converters;

import org.example.domain.requestedCoin.RequestedCoin;
import org.example.view.model.CoinView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestedCoinToCoinViewConverter implements Converter<RequestedCoin, CoinView> {

    @Override
    public CoinView convert(RequestedCoin requestedCoin) {
        return new CoinView(requestedCoin.getSymbol(), requestedCoin.getPriceChange(), requestedCoin.getPriceChangePercent(), requestedCoin.getOpenPrice(), requestedCoin.getHighPrice(), requestedCoin.getLowPrice());
    }

}
