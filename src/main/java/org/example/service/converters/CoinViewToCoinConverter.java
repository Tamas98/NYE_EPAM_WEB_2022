package org.example.service.converters;

import org.example.domain.coin.Coin;
import org.example.view.model.CoinView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CoinViewToCoinConverter implements Converter<CoinView, Coin> {
    @Override
    public Coin convert(CoinView source) {
        return new Coin(source.getSymbol(),source.getPriceChange(), source.getPriceChangePercentage(), source.getOpenPrice(), source.getHighPrice(), source.getLowPrice());
    }
}
