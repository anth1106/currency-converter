/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class SetRatiosFrame extends JPanel {

    //ATTRIBUTES
    private final ActionListener listener;
    private final CurrencyConverter model;
    private JComboBox comboxCurrency;
    private JTextField tfCurrency;
    private JButton btChange;

    //CONSTRUCTORS
    public SetRatiosFrame(ViewController controller) {
        this.listener = controller;
        this.model = controller.getModel();
        initComponents();
    }

    //SETTERS AND GETTERS
    /**
     * @return the comboxCurrency
     */
    public JComboBox getComboxCurrency() {
        return comboxCurrency;
    }

    /**
     * @return the tfCurrency
     */
    public JTextField getTfCurrency() {
        return tfCurrency;
    }

    //METHODS
    private void initComponents() {
        setLayout(new GridLayout(2, 2));
        comboxCurrency = loadCombox();
        tfCurrency = new JTextField(20);

        btChange = new JButton("Change");
        btChange.setActionCommand("change");
        btChange.addActionListener(listener);

        add(getComboxCurrency());
        add(getTfCurrency());
        add(btChange);
    }
    /**
     * load combox with data from model, if data is empty combox will be empty too
     * @return combox with data
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
