package org.example.service.transformer;

import org.example.domain.coin.Coin;
import org.example.view.model.CoinView;

public class CoinToCoinViewTransformer {

    public CoinView convert(Coin coin) {
        return new CoinView(coin.getSymbol(), coin.getPriceChange(), coin.getPriceChangePercent(), coin.getOpenPrice(), coin.getHighPrice(), coin.getLowPrice());
    }
}
