package net.ddns.dankest.webservices;

import net.ddns.dankest.webservices.gui.ImageGUI;
import net.ddns.dankest.webservices.gui.RESTGUI;
import net.ddns.dankest.webservices.gui.WSGUI;

import javax.xml.rpc.ServiceException;

public class GUIMain {

    public static String city = "Pontoise";

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
