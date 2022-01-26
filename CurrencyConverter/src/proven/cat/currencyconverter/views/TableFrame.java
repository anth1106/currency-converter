/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.cat.currencyconverter.views;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import proven.cat.currencyconverter.controller.ViewController;
import proven.cat.currencyconverter.model.Coin;
import proven.cat.currencyconverter.model.CurrencyConverter;

/**
 *
 * @author Anthh
 */
public class TableFrame extends JPanel {

    //ATTRIBUTES
    private final CurrencyConverter model;
    private final List<Coin> currencies;
    private JTable table;

    //CONSTRUCTORS
    public TableFrame(ViewController controller) {
        this.model = controller.getModel();
        this.currencies = model.getCurrencies();
        initComponents();
    }

    //METHODS
    private void initComponents() {
        setLayout(new BorderLayout());
        setTable();

    }
    
    /**
     * set the data on the table and display it on the pane
     */
    private void setTable() {
        String[] columnNames = {"Name", "Dolar ratio"};
        Object[][] data = fillData(columnNames);
        table = new JTable(data, columnNames);
        table.setAutoCreateRowSorter(true);
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * fill a bidimentional array with the data for the table and return it, if
     * theres no data on the model data will be empty
     * @param columnNames string array with the name for the columns of the table
     * @return a bidimentional array with data for table
     */
    private Object[][] fillData(String[] columnNames) {
        String[][] data = new String[currencies.size()][columnNames.length];
        for (int i = 0; i < currencies.size(); i++) {
            data[i][0] = currencies.get(i).getName();
            data[i][1] = String.valueOf(currencies.get(i).getDolarRatio());
        }
        return data;
    }

}
