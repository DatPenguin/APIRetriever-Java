package net.ddns.dankest.webservices;

import net.ddns.dankest.webservices.gui.BTCEURGUI;
import net.ddns.dankest.webservices.gui.RESTGUI;
import net.ddns.dankest.webservices.gui.WSGUI;

import javax.xml.rpc.ServiceException;

public class GUIMain {
    public static void main(String[] args) {
        try {
            new WSGUI();
            new RESTGUI();
            new BTCEURGUI();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
