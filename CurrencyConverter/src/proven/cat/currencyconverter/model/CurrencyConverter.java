package proven.cat.currencyconverter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model to conver between currencies
 *
 * @author Anthh
 */
public class CurrencyConverter {

    //ATTRIBUTES
    private List<Coin> currencies;

    //CONSTRUCTORS
    public CurrencyConverter() {
        currencies = new ArrayList<>();
        loadCurrencies();
    }

    public CurrencyConverter(CurrencyConverter other) {
        this.currencies = other.currencies;
    }

    public CurrencyConverter(List<Coin> currencies) {
        this.currencies = currencies;
    }

    //SETTERS AND GETTERS
    public List<Coin> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Coin> currencies) {
        this.currencies = currencies;
    }

    /**
     * convert the currency given value to the currency given to exchange for
     * and return the exchaged value of the currency
     *
     * @param value value of the currency to exchange
     * @param currentCurrency the name of the currency to exchange
     * @param currencyExchange the name of the currency user want to exchange
     * the value in
     * @return
     */
    public double change(double value, String currentCurrency, String currencyExchange) {
        double result;
        
        int indexCurrent = currencies.indexOf(new Coin(currentCurrency.toLowerCase()));
        double currentRatio = currencies.get(indexCurrent).getDolarRatio();

        int indexExchange = currencies.indexOf(new Coin(currencyExchange.toLowerCase()));
        double exchangeRatio = currencies.get(indexExchange).getDolarRatio();

        result = value * currentRatio / exchangeRatio;

        return result;
    }

    //test data
    private void loadCurrencies() {
        currencies.add(new Coin("usd", 1.000));
        currencies.add(new Coin("eur", 1.1940));
        currencies.add(new Coin("gbp", 1.3390));
    }
}
