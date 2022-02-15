package org.example.service;

import org.example.domain.coin.supplier.CoinListSupplier;
import org.example.service.comparator.CoinChangePercentageComparator;
import org.example.service.converters.CoinToCoinViewConverter;
import org.example.view.model.CoinView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinSearcherService implements CoinSearcher {

    private final CoinListSupplier coinListSupplier;
    private final CoinChangePercentageComparator coinChangePercentageComparator;
    private final CoinToCoinViewConverter coinToCoinViewConverter;

    @Autowired
    public CoinSearcherService(CoinListSupplier coinListSupplier, CoinChangePercentageComparator coinChangePercentageComparator, CoinToCoinViewConverter coinToCoinViewConverter) {
        this.coinListSupplier = coinListSupplier;
        this.coinChangePercentageComparator = coinChangePercentageComparator;
        this.coinToCoinViewConverter = coinToCoinViewConverter;
    }

    public List<CoinView> searchCoinsByName(String keyword) {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> coin.getSymbol().contains(keyword))
                .map(coinToCoinViewConverter::convert)
                .collect(Collectors.toList());
    }

    public List<CoinView> searchPositivePriceChange() {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> 0 < coin.getPriceChangePercent())
                .map(coinToCoinViewConverter::convert)
                .collect(Collectors.toList());
    }

    public List<CoinView> searchPriceRange(float min, float max) {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> min <= coin.getOpenPrice() && coin.getOpenPrice() <= max)
                .map(coinToCoinViewConverter::convert)
                .collect(Collectors.toList());
    }

    public List<CoinView> searchTopGainers() {
        return coinListSupplier.get().getCoinList().stream()
                .sorted(coinChangePercentageComparator)
                .limit(10)
                .map(coinToCoinViewConverter::convert)
                .collect(Collectors.toList());
    }
}
