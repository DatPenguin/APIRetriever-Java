package net.ddns.dankest.webservices;

import net.ddns.dankest.webservices.gui.ImageGUI;
import net.ddns.dankest.webservices.gui.RESTGUI;
import net.ddns.dankest.webservices.gui.WSGUI;

import javax.xml.rpc.ServiceException;

public class GUIMain {

    /**
     * Used to get the Picture of the last city we looked for
     */
    public static String city = "Pontoise";

    /**
     * Tries to run the three frames. Each one of them shows information obtained by different means.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            new WSGUI();
            new RESTGUI();
            new ImageGUI();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
