package org.example.service.handler;

import org.example.domain.coin.DAO.DAO;
import org.example.domain.coin.Coin;
import org.example.view.model.CoinView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinHandlerService implements CoinHandler {

    private final DAO<Coin> coinDAO;
    private final ConversionService conversionService;

    @Autowired
    public CoinHandlerService(DAO<Coin> coinDAO, ConversionService conversionService) {
        this.coinDAO = coinDAO;
        this.conversionService = conversionService;
    }

    @Override
    public void saveCoin(CoinView coinView) {
        coinDAO.save(conversionService.convert(coinView, Coin.class));
    }

    @Override
    public void saveAllCoins(List<CoinView> toSave) {
        coinDAO.saveAll(toSave.stream().map(coinView -> conversionService.convert(coinView, Coin.class)).collect(Collectors.toList()));
    }

    @Override
    public void deleteCoinById(Long id) {
        coinDAO.deleteById(id);
    }

    @Override
    public List<CoinView> getAllCoins() {
        return coinDAO.getAll().stream().map(savedCoin -> conversionService.convert(savedCoin, CoinView.class)).collect(Collectors.toList());
    }
}
