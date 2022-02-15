package org.example.view;

import org.example.domain.coin.supplier.CoinListSupplier;
import org.example.service.CoinSearcher;
import org.example.service.CoinSearcherService;
import org.example.service.comparator.CoinChangePercentageComparator;

public class PrintCoins {

    private final CoinSearcher coinSearcherService;

    public PrintCoins(CoinSearcher coinSearcherService) {
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
