package org.example.service.converters;

import org.example.domain.coin.Coin;
import org.example.view.model.CoinView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CoinToCoinViewConverter implements Converter<Coin, CoinView> {
    @Override
    public CoinView convert(Coin source) {
        return new CoinView(source.getSymbol(),source.getPriceChange(), source.getPriceChangePercent(), source.getOpenPrice(), source.getHighPrice(), source.getLowPrice());
    }
}
