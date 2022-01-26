package proven.cat.currencyconverter.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proven.cat.currencyconverter.controller.ViewController;
import proven.cat.currencyconverter.model.Coin;
import proven.cat.currencyconverter.model.CurrencyConverter;

/**
 *
 * @author Anthh
 */
public class CalculateFrame extends JPanel {

    //ATTRIBUTES
    private final ActionListener listener;
    private final CurrencyConverter model;
    private JComboBox comboxCurrent;
    private JTextField tfCurrent;
    private JComboBox comboxExchange;
    private JTextField tfExchange;
    private JButton btConvert;
    private JButton btClear;

    //CONSTRUCTORS
    public CalculateFrame(ViewController controller) {
        this.listener = controller;
        this.model = controller.getModel();
        initComponents();
    }

    //SETTERS AND GETTERS
    public JButton getBtClear() {
        return btClear;
    }

    public void setBtClear(JButton btClear) {
        this.btClear = btClear;
    }

    /**
     * @return the comboxCurrent
     */
    public JComboBox getComboxCurrent() {
        return comboxCurrent;
    }

    /**
     * @param comboxCurrent the comboxCurrent to set
     */
    public void setComboxCurrent(JComboBox comboxCurrent) {
        this.comboxCurrent = comboxCurrent;
    }

    /**
     * @return the tfCurrent
     */
    public JTextField getTfCurrent() {
        return tfCurrent;
    }

    /**
     * @param tfCurrent the tfCurrent to set
     */
    public void setTfCurrent(JTextField tfCurrent) {
        this.tfCurrent = tfCurrent;
    }

    /**
     * @return the comboxExchange
     */
    public JComboBox getComboxExchange() {
        return comboxExchange;
    }

    /**
     * @param comboxExchange the comboxExchange to set
     */
    public void setComboxExchange(JComboBox comboxExchange) {
        this.comboxExchange = comboxExchange;
    }

    /**
     * @return the tfExchange
     */
    public JTextField getTfExchange() {
        return tfExchange;
    }

    /**
     * @param tfExchange the tfExchange to set
     */
    public void setTfExchange(JTextField tfExchange) {
        this.tfExchange = tfExchange;
    }

    //METHODS
    private void initComponents() {
        setLayout(new GridLayout(3, 2));
        setComboxCurrent(loadCombox());
        setComboxExchange(loadCombox());
        setTfCurrent(new JTextField(20));
        setTfExchange(new JTextField(20));

        btClear = new JButton("Clear");
        btClear.setActionCommand("clear");
        btClear.addActionListener(listener);

        btConvert = new JButton("Convert");
        btConvert.setActionCommand("convert");
        btConvert.addActionListener(listener);

        add(getComboxCurrent());
        add(getTfCurrent());
        add(getComboxExchange());
        add(getTfExchange());
        add(btClear);
        add(btConvert);
    }

    /**
     * load the combox with data of the currencies from model, if empty combox
     * will be empty too
     * @return cmbox with data
     */
    private JComboBox loadCombox() {
        JComboBox combo = new JComboBox();
        List<Coin> modelCurrency = model.getCurrencies();
        for (Coin c : modelCurrency) {
            combo.addItem(c.getName().toUpperCase());
        }
        return combo;
    }

}
