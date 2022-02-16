package org.example.domain.coin.DAO;

import org.example.domain.coin.Coin;
import org.example.domain.coin.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CoinDAO implements DAO<Coin> {

    private final CoinRepository savedCoinRepository;

    @Autowired
    public CoinDAO(CoinRepository savedCoinRepository) {
        this.savedCoinRepository = savedCoinRepository;
    }
    @Override
    public Optional<Coin> get(Long id) {
        return savedCoinRepository.findById(id);
    }

    @Override
    public List<Coin> getAll() {
        return savedCoinRepository.findAll();
    }

    @Override
    public void save(Coin savedCoin) {
        savedCoinRepository.save(savedCoin);
    }

    @Override
    public void deleteById(Long id) {
        savedCoinRepository.deleteById(id);
    }

    @Override
    public void saveAll(List<Coin> coinList) {
        savedCoinRepository.saveAll(coinList);
    }
}
