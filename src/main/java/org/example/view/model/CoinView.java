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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(float priceChange) {
        this.priceChange = priceChange;
    }

    public float getPriceChangePercentage() {
        return priceChangePercentage;
    }

    public void setPriceChangePercentage(float priceChangePercentage) {
        this.priceChangePercentage = priceChangePercentage;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    public float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(float highPrice) {
        this.highPrice = highPrice;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
    }
}
