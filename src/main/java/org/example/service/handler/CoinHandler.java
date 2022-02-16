package org.example.service.handler;

import org.example.view.model.CoinView;

import java.util.List;

public interface CoinHandler {

    void saveCoin(CoinView coinView);
    void saveAllCoins(List<CoinView> toSave);
    void deleteCoinById(Long id);
    List<CoinView> getAllCoins();
}
