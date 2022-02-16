package org.example.view;

import org.example.service.searcher.CoinSearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCoins {

    private final CoinSearcherService coinSearcherService;

    @Autowired
    public PrintCoins(CoinSearcherService coinSearcherService) {
        this.coinSearcherService = coinSearcherService;
    }

    public void printTopGainers() {
        coinSearcherService.searchTopGainers().forEach(System.out::println);
    }

    public void printSearchResult(String keyword) {
        coinSearcherService.searchCoinsByName(keyword).forEach(System.out::println);
    }

    public void printGainers() {
        coinSearcherService.searchPositivePriceChange().forEach(System.out::println);
    }

    public void printCoinsWithinPriceRange(float min, float max) {
        coinSearcherService.searchPriceRange(min, max).forEach(System.out::println);
    }
}
