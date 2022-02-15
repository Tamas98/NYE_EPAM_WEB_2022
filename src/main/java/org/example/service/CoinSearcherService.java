package org.example.service;

import org.example.domain.coin.supplier.CoinListSupplier;
import org.example.service.comparator.CoinChangePercentageComparator;
import org.example.view.model.CoinView;
import org.example.service.transformer.CoinToCoinViewConverter;

import java.util.List;
import java.util.stream.Collectors;

public class CoinSearcherService implements CoinSearcher {

    private final CoinListSupplier coinListSupplier;
    private final CoinChangePercentageComparator coinChangePercentageComparator;
    private final CoinToCoinViewConverter coinToCoinViewTransformer;

    public CoinSearcherService(CoinListSupplier coinListSupplier, CoinChangePercentageComparator coinChangePercentageComparator, CoinToCoinViewConverter coinToCoinViewTransformer) {
        this.coinListSupplier = coinListSupplier;
        this.coinChangePercentageComparator = coinChangePercentageComparator;
        this.coinToCoinViewTransformer = coinToCoinViewTransformer;
    }

    public List<CoinView> searchCoinsByName(String keyword) {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> coin.getSymbol().contains(keyword))
                .map(coinToCoinViewTransformer::convert)
                .collect(Collectors.toList());
    }

    public List<CoinView> searchPositivePriceChange() {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> 0 < coin.getPriceChangePercent())
                .map(coinToCoinViewTransformer::convert)
                .collect(Collectors.toList());
    }

    public List<CoinView> searchPriceRange(float min, float max) {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> min <= coin.getOpenPrice() && coin.getOpenPrice() <= max)
                .map(coinToCoinViewTransformer::convert)
                .collect(Collectors.toList());
    }

    public List<CoinView> searchTopGainers() {
        return coinListSupplier.get().getCoinList().stream()
                .sorted(coinChangePercentageComparator)
                .limit(10)
                .map(coinToCoinViewTransformer::convert)
                .collect(Collectors.toList());
    }
}
