package org.example.service.searcher;

import org.example.domain.requestedCoin.supplier.CoinListSupplier;
import org.example.service.comparator.CoinChangePercentageComparator;
import org.example.service.converters.RequestedCoinToCoinViewConverter;
import org.example.view.model.CoinView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinSearcherService implements CoinSearcher {

    private final CoinListSupplier coinListSupplier;
    private final CoinChangePercentageComparator coinChangePercentageComparator;
    private final ConversionService conversionService;

    @Autowired
    public CoinSearcherService(CoinListSupplier coinListSupplier, CoinChangePercentageComparator coinChangePercentageComparator, ConversionService conversionService) {
        this.coinListSupplier = coinListSupplier;
        this.coinChangePercentageComparator = coinChangePercentageComparator;
        this.conversionService = conversionService;
    }

    @Override
    public List<CoinView> getAllCoins() {
        return coinListSupplier.get().getCoinList().stream()
                .map(coin -> conversionService.convert(coin, CoinView.class))
                .collect(Collectors.toList());
    }

    public List<CoinView> searchCoinsByName(String keyword) {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> coin.getSymbol().contains(keyword))
                .map(requestedCoin -> conversionService.convert(requestedCoin, CoinView.class))
                .collect(Collectors.toList());
    }

    public List<CoinView> searchPositivePriceChange() {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> 0 < coin.getPriceChangePercent())
                .map(requestedCoin -> conversionService.convert(requestedCoin, CoinView.class))
                .collect(Collectors.toList());
    }

    public List<CoinView> searchPriceRange(float min, float max) {
        return coinListSupplier.get().getCoinList().stream()
                .filter(coin -> min <= coin.getOpenPrice() && coin.getOpenPrice() <= max)
                .map(requestedCoin -> conversionService.convert(requestedCoin, CoinView.class))
                .collect(Collectors.toList());
    }

    public List<CoinView> searchTopGainers() {
        return coinListSupplier.get().getCoinList().stream()
                .sorted(coinChangePercentageComparator)
                .limit(10)
                .map(requestedCoin -> conversionService.convert(requestedCoin, CoinView.class))
                .collect(Collectors.toList());
    }
}
