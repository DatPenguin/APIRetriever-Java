package net.ddns.dankest.webservices;

import net.ddns.dankest.webservices.gui.WSGUI;

import javax.xml.rpc.ServiceException;

public class GUIMain {
    public static void main(String[] args) {
        try {
            new WSGUI();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
