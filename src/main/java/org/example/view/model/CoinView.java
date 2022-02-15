package org.example.view.model;

public class CoinView {

    private String symbol;
    private float priceChange;
    private float priceChangePercentage;
    private float openPrice;
    private float highPrice;
    private float lowPrice;

    public CoinView(String symbol, float priceChange, float priceChangePercentage, float openPrice, float highPrice, float lowPrice) {
        this.symbol = symbol;
        this.priceChange = priceChange;
        this.priceChangePercentage = priceChangePercentage;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
    }

    @Override
    public String toString() {
        return "CoinView{" +
                "symbol='" + symbol + '\'' +
                ", priceChange=" + priceChange +
                ", priceChangePercentage=" + priceChangePercentage +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                '}';
    }
}
