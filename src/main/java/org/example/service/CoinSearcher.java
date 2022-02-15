package org.example.service;

import org.example.domain.coin.Coin;
import org.example.view.model.CoinView;

import java.util.List;

public interface CoinSearcher {

    List<CoinView> searchCoinsByName(String keyword);
    List<CoinView> searchPositivePriceChange();
    List<CoinView> searchPriceRange(float min, float max);
    List<CoinView> searchTopGainers();
}
