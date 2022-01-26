/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.cat.currencyconverter.views;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import proven.cat.currencyconverter.controller.ViewController;

/**
 *
 * @author Anthh
 */
public class MainFrame extends JFrame {

    //ATTRIBUTES
    private final ViewController controller;
    private CalculateFrame calcPane;
    private SetRatiosFrame confPane;
    private TableFrame tablePane;
    private final String title;
    private final ActionListener listener;
    private JMenuBar menuBar;
    private final String aboutMessage;

    //CONSTRUCTOR
    public MainFrame(ViewController controller) {
        this.title = "Currency converter application";
        this.controller = controller;
        this.listener = controller;
        aboutMessage = "<html><b>Currency converter</b><p>(c) ProvenSoft 2020</p></html>";
        initComponents();
    }

    //SETTERS AND GETTERS
    public CalculateFrame getCalcPane() {
        return calcPane;
    }

    public void setCalcPane(CalculateFrame calcPane) {
        this.calcPane = calcPane;
    }

    public SetRatiosFrame getConfPane() {
        return confPane;
    }

    public void setConfPane(SetRatiosFrame confPane) {
        this.confPane = confPane;
    }

    public TableFrame getTablePane() {
        return tablePane;
    }

    public void setTablePane(TableFrame tablePane) {
        this.tablePane = tablePane;
    }

    //METHODS
    
    private void initComponents() {
        setTitle(title);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.exitApplication();
            }
        });
        //build menu
        menuBar = BuildMenubar();
        setJMenuBar(menuBar);
        //load welcome panel
        getContentPane().add(new WelcomePanel());
        //
        setLocationRelativeTo(null);
        setSize(400, 300);
    }

    /**
     * build a menu bar for main frame with all options to use in currency converter
     * @return menubar with 4 submenus
     */
    private JMenuBar BuildMenubar() {
        JMenuBar mnuBar = new JMenuBar();
        JMenu mnu;
        JMenuItem mItem;
        //File(exit), Convert(Calculate, Set ratios), Help(About)
        //File
        mnu = new JMenu("File");
        mnuBar.add(mnu);
        mItem = new JMenuItem("Exit");
        mItem.setActionCommand("exit");
        mItem.addActionListener(listener);
        mnu.add(mItem);
        //Convert
        mnu = new JMenu("Edit");
        mnuBar.add(mnu);
        mItem = new JMenuItem("Calculate");
        mItem.setActionCommand("calculate");
        mItem.addActionListener(listener);
        mnu.add(mItem);
        mItem = new JMenuItem("Set ratios");
        mItem.setActionCommand("setRatio");
        mItem.addActionListener(listener);
        mnu.add(mItem);
        mItem = new JMenuItem("Show Currencies");
        mItem.setActionCommand("showCurrencies");
        mItem.addActionListener(listener);
        mnu.add(mItem);
        //Help
        mnu = new JMenu("Help");
        mnuBar.add(mnu);
        mItem = new JMenuItem("About");
        mItem.setActionCommand("about");
        mItem.addActionListener(listener);
        mnu.add(mItem);
        return mnuBar;
    }

    /**
     * display the calculate pane on main frame
     */
    public void showCalcPane() {
        //display currency conversion form.
        calcPane = new CalculateFrame(controller);
        setContentPane(calcPane);
        this.validate();
    }

    /**
     * display the about dialog on the main frame
     */
    public void displayAboutDialog() {
        JOptionPane.showMessageDialog(this, aboutMessage);
    }

    /**
     * display the config pane on the main frame
     */
    public void showConfPane() {
        confPane = new SetRatiosFrame(controller);
        setContentPane(confPane);
        this.validate();
    }
    
    /**
     * display the table with all the data of currencies on the main frame
     */
    public void showTablePane() {
        tablePane = new TableFrame(controller);
        setContentPane(tablePane);
        this.validate();
    }

}
