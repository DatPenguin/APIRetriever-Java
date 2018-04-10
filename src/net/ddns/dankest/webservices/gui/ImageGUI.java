package net.ddns.dankest.webservices.gui;

import net.ddns.dankest.webservices.GUIMain;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

/**
 * The Frame that displays the city picture
 */
public class ImageGUI extends JFrame implements ActionListener {
    private JLabel bigLabel = new JLabel("City Picture");
    private JLabel image = new JLabel();
    private JButton refresh = new JButton("Refresh");

    public ImageGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setTitle("City Picture");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(458, 432);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        refresh.setBounds(309, 375, 75, 23);
        this.add(refresh);

        bigLabel.setFont(bigLabel.getFont().deriveFont(16f));
        bigLabel.setBounds(60, 35, 185, 25);
        this.add(bigLabel);

        image.setBounds(10, 60, this.getWidth() - 30, 300);
        image.setBackground(null);
        this.add(image);

        SwingUtilities.getRootPane(refresh).setDefaultButton(refresh);
        refresh.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refresh && GUIMain.city != null) {
            getImage();
        }
    }

    /**
     * Downloads the image and displays it
     */
    private void getImage() {
        try {
            /*
             * We get the URL of the image we want by querying the API
             */
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=pageimages&format=json&pithumbsize=500&titles=" + GUIMain.city);
            URLConnection con = url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = IOUtils.toString(in, encoding);
            JSONObject json = new JSONObject(body);

            Iterator keys = json.getJSONObject("query").getJSONObject("pages").keys();
            String pageID = (String) keys.next();

            String imgUrl = json.getJSONObject("query").getJSONObject("pages").getJSONObject(pageID).getJSONObject("thumbnail").getString("source");    // Parsing the API to get the URL

            BufferedImage bi = ImageIO.read(new URL(imgUrl));   // Once we get the Image URL, we read it with a BufferedReader
            ImageIcon img = new ImageIcon(bi);                  // We finally display the image by creating an icon from it...

            image.setIcon(img);                                 // And setting it as a label icon
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
