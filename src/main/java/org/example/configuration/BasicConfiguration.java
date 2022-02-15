package org.example.configuration;

import org.example.domain.coin.supplier.CoinListSupplier;
import org.example.service.CoinSearcher;
import org.example.service.CoinSearcherService;
import org.example.service.comparator.CoinChangePercentageComparator;
import org.example.view.PrintCoins;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.service.transformer.CoinToCoinViewConverter;

@Configuration
public class BasicConfiguration {

    @Bean
    public CoinChangePercentageComparator coinChangePercentageComparator() {
        return new CoinChangePercentageComparator();
    }

    @Bean
    public CoinToCoinViewConverter coinToCoinViewConverter() {
        return new CoinToCoinViewConverter();
    }

    @Bean
    public CoinListSupplier coinListSupplier() {
        return new CoinListSupplier();
    }

    @Bean
    public CoinSearcher coinSearcher() {
        return new CoinSearcherService(coinListSupplier(), coinChangePercentageComparator(), coinToCoinViewConverter());
    }

    @Bean
    public PrintCoins printCoins() {
        return new PrintCoins(coinSearcher());
    }
}
