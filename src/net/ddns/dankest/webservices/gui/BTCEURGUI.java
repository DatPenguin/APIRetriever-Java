package net.ddns.dankest.webservices.gui;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class BTCEURGUI extends JFrame implements ActionListener {
    private JLabel bigLabel = new JLabel("Bitcoin exchange rate");
    private JLabel rateLabel = new JLabel();
    private JButton refresh = new JButton("Refresh");

    public BTCEURGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setTitle("Bitcoin Exchange Rate");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(458, 432);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        refresh.setBounds(309, 343, 75, 23);
        this.add(refresh);

        bigLabel.setFont(bigLabel.getFont().deriveFont(16f));
        bigLabel.setBounds(60, 35, 185, 25);
        this.add(bigLabel);

        rateLabel.setBounds(60, 60, 100, 25);
        rateLabel.setBackground(null);
        this.add(rateLabel);

        SwingUtilities.getRootPane(refresh).setDefaultButton(refresh);
        refresh.addActionListener(this);

        getExchangeRate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refresh) {
            getExchangeRate();
        }
    }

    public void getExchangeRate() {
        try {
            URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
            URLConnection con = url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = IOUtils.toString(in, encoding);
            JSONObject json = new JSONObject(body);
            rateLabel.setText(json.getJSONObject("bpi").getJSONObject("EUR").getString("rate") + " €");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
