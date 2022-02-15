package org.example.service.transformer;

import org.example.domain.coin.Coin;
import org.example.view.model.CoinView;
import org.springframework.cglib.core.Transformer;
import org.springframework.core.convert.converter.Converter;

public class CoinToCoinViewTransformer implements Converter<Coin, CoinView> {

    @Override
    public CoinView convert(Coin coin) {
        return new CoinView(coin.getSymbol(), coin.getPriceChange(), coin.getPriceChangePercent(), coin.getOpenPrice(), coin.getHighPrice(), coin.getLowPrice());
    }
    
}
