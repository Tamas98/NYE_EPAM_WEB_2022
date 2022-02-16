package org.example.service.searcher;

import org.example.view.model.CoinView;

import java.util.List;

public interface CoinSearcher {

    List<CoinView> getAllCoins();
    List<CoinView> searchCoinsByName(String keyword);
    List<CoinView> searchPositivePriceChange();
    List<CoinView> searchPriceRange(float min, float max);
    List<CoinView> searchTopGainers();
}
