package org.example.view;

import org.example.service.handler.CoinHandler;
import org.example.service.searcher.CoinSearcher;
import org.example.view.model.CoinView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoinController {

    private final CoinHandler coinHandler;
    private final CoinSearcher coinSearcher;

    @Autowired
    public CoinController(CoinHandler coinHandler, CoinSearcher coinSearcher) {
        this.coinHandler = coinHandler;
        this.coinSearcher = coinSearcher;
    }

    @GetMapping("/saved/coins")
    public ResponseEntity<List<CoinView>> getAllSavedCoin() {
        return new ResponseEntity<>(coinHandler.getAllCoins(), HttpStatus.OK);
    }

    @GetMapping("/coins")
    public ResponseEntity<List<CoinView>> getAllCoin() {
        return new ResponseEntity<>(coinSearcher.getAllCoins(), HttpStatus.OK);
    }

    @PostMapping("/save/all")
    public ResponseEntity<HttpStatus> saveAllCoin() {
        coinHandler.saveAllCoins(coinSearcher.getAllCoins());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCoinById(@PathVariable("id") long id) {
        coinHandler.deleteCoinById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
