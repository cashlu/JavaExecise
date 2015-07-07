package testGUI.testAWT;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by cashlu on 15/7/4.
 */
public class MyWindow extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.out.println("Window is Closing...");
        System.exit(0);
    }

    public void windowClosed(WindowEvent e){
        System.out.println("Closed");
    }

    public void windowActivated(WindowEvent e){
        System.out.println("Activated");
    }

    public void windowOpened(WindowEvent e){
        System.out.println("Opend");
    }
}
