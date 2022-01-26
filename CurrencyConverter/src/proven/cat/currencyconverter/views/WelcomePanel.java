/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.cat.currencyconverter.views;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Anthh
 */
public class WelcomePanel extends JPanel{
    private String welcomeMessage;

    public WelcomePanel() {
        welcomeMessage = "Welcome to currency converter";
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        JLabel welcomeLbl = new JLabel(welcomeMessage);
        this.setBackground(Color.LIGHT_GRAY);
        add(welcomeLbl, BorderLayout.CENTER);

    }
}
