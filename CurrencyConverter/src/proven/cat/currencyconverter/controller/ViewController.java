package proven.cat.currencyconverter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import proven.cat.currencyconverter.model.Coin;
import proven.cat.currencyconverter.model.CurrencyConverter;
import proven.cat.currencyconverter.views.MainFrame;

/**
 *
 * @author Anthh
 */
public class ViewController implements ActionListener {

    //ATTRIBUTES
    private CurrencyConverter model;
    private MainFrame mainframe;

    //CONSTRUCTORS
    public ViewController() {
    }

    public ViewController(CurrencyConverter model) {
        this.model = model;
    }

    public ViewController(ViewController other) {
        this.model = other.model;
        this.mainframe = other.mainframe;
    }

    //GETTERS AND SETTERS
    public void setModel(CurrencyConverter model) {
        this.model = model;
    }

    public CurrencyConverter getModel() {
        return model;
    }

    public MainFrame getMainframe() {
        return mainframe;
    }

    public void setMainframe(MainFrame mainframe) {
        this.mainframe = mainframe;
    }

    //METHODS
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case "exit"://exit app
                exitApplication();
                break;
            case "calculate":
                mainframe.showCalcPane();
                break;
            case "setRatio":
                mainframe.showConfPane();
                break;
            case "showCurrencies":
                mainframe.showTablePane();
                break;
            case "about": //display about dialog
                mainframe.displayAboutDialog();
                break;
            case "convert":
                convert();
                break;
            case "clear":
                ClearValues();
                break;
            case "change":
                changeValueOfCoin();
                break;
            default:
                break;
        }
        System.out.println("Execuing " + action);
    }

    /**
     * exits the application and close all frames
     */
    public void exitApplication() {
        int answer = JOptionPane.showConfirmDialog(mainframe, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    /**
     * converts the text in the text field of current value(first textfield) and
     * convert it into the other currency and display it as text in the exchange
     * textfield(second textfield)
     */
    private void convert() {
        try {
            double currency = Double.parseDouble(mainframe.getCalcPane().getTfCurrent().getText());
            String current = mainframe.getCalcPane().getComboxCurrent().getSelectedItem().toString();
            String exchange = mainframe.getCalcPane().getComboxExchange().getSelectedItem().toString();

            double result = model.change(currency, current, exchange);
            mainframe.getCalcPane().getTfExchange().setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            System.out.println("Cant parse to double");
        }
    }

    /**
     * change the value of the dolar ratio of the selected currency with the
     * value in the textfield, replace the value in the list of currencies, if
     * cant change it shows a message in the console
     */
    private void changeValueOfCoin() {
        try {
            String currency = mainframe.getConfPane().getComboxCurrency().getSelectedItem().toString().toLowerCase();
            double changeRatio = Double.parseDouble(mainframe.getConfPane().getTfCurrency().getText());
            Coin c = new Coin(currency, changeRatio);

            List<Coin> currencies = model.getCurrencies();
            int i = currencies.indexOf(c);
            currencies.set(i, c);
        } catch (NumberFormatException ex) {
            System.out.println("Cant parse to double");
        }
    }

    private void ClearValues() {
        mainframe.getCalcPane().getTfCurrent().setText("");
        mainframe.getCalcPane().getTfExchange().setText("");
    }

}
