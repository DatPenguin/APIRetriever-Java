package net.ddns.dankest.webservices.gui;

import net.ddns.dankest.webservices.GUIMain;
import net.ddns.dankest.webservices.ws.APIRetrieverServiceLocator;
import net.ddns.dankest.webservices.ws.APIRetriever_PortType;
import org.json.JSONObject;

import javax.swing.*;
import javax.xml.rpc.ServiceException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GUI displaying the infos retrieved from the SOAP service
 */
public class WSGUI extends JFrame implements ActionListener {
    /**
     * The SOAP Client we generated through IntelliJ. Needed to access data.
     */
    APIRetriever_PortType service = new APIRetrieverServiceLocator().getAPIRetriever();

    private JLabel fieldLabel = new JLabel("City :");
    private JLabel cityName = new JLabel("Enter a city name");
    private JLabel weatherLabel = new JLabel("Weather :");
    private JLabel weather = new JLabel();
    private JLabel tempLabel = new JLabel("Temperature :");
    private JLabel temp = new JLabel();
    private JTextArea descriptionArea = new JTextArea();
    private JTextField field = new JTextField("Pontoise");
    private JButton validate = new JButton("OK");

    /**
     * Creates the frame and sets up its components
     *
     * @throws ServiceException
     */
    public WSGUI() throws ServiceException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setTitle("APIRetriever SOAP Java Client");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(458, 432);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        fieldLabel.setFont(fieldLabel.getFont().deriveFont(12f));
        fieldLabel.setBounds(59, 344, 43, 20);
        this.add(fieldLabel);

        field.setBounds(108, 343, 182, 23);
        this.add(field);

        validate.setBounds(309, 343, 75, 23);
        this.add(validate);

        cityName.setFont(cityName.getFont().deriveFont(16f));
        cityName.setBounds(60, 35, 185, 25);
        this.add(cityName);

        descriptionArea.setBounds(65, 63, 350, 150);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(null);
        this.add(descriptionArea);

        weatherLabel.setBounds(79,273,100,20);
        this.add(weatherLabel);

        weather.setBounds(160, 273, 200, 20);
        this.add(weather);

        tempLabel.setBounds(54, 301, 100, 20);
        this.add(tempLabel);

        temp.setBounds(159, 301, 200, 20);
        this.add(temp);

        SwingUtilities.getRootPane(validate).setDefaultButton(validate);
        validate.addActionListener(this);
    }

    /**
     * Fired when an action is performed on the frame
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == validate) {
            try {
                JSONObject json = new JSONObject(service.getResult(field.getText().replaceAll(" ", "%20")));    // Directly getting the JSON Object from the service

                /*
                 * Storing the data into variables
                 */
                cityName.setText(json.getString("name"));
                descriptionArea.setText(json.getString("desc"));
                temp.setText(json.getString("temp") + " °C");
                weather.setText(json.getString("weather").substring(0, 1).toUpperCase() + json.getString("weather").substring(1));
                GUIMain.city = field.getText();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
