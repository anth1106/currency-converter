package proven.cat.currencyconverter;

import javax.swing.SwingUtilities;
import proven.cat.currencyconverter.controller.ViewController;
import proven.cat.currencyconverter.model.CurrencyConverter;
import proven.cat.currencyconverter.views.MainFrame;

/**
 *
 * @author Anthh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //get out of static context
        Main app = new Main();
        app.run();
    }
    
    /**
     * run the program
     */
    private void run() {
        //instantiate and initialize model
        CurrencyConverter currencyConverter = new CurrencyConverter();
        //instantiate and initialize controller
        ViewController controller = new ViewController(currencyConverter);
        //run the main frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //instantiate and initialize main frame
                MainFrame mainFrame = new MainFrame(controller);
                //set main frame in controller
                controller.setMainframe(mainFrame);
                mainFrame.setVisible(true);
            }
        });
    }
    
}
