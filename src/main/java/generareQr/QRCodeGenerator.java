/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.zxing.BarcodeFormat
 *  com.google.zxing.EncodeHintType
 *  com.google.zxing.WriterException
 *  com.google.zxing.common.BitMatrix
 *  com.google.zxing.qrcode.QRCodeWriter
 *  com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
 */
package generareQr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QRCodeGenerator {
    private JFrame frame;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField jobTitleField;
    private JTextField telField;
    private JTextField emailField;
    private JTextField urlField;
    private JTextField officeField;
    private JLabel qrLabel;
    private BufferedImage qrImage;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                QRCodeGenerator window = new QRCodeGenerator();
                window.frame.setVisible(true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public QRCodeGenerator() {
        this.initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.frame.setBounds(100, 100, 500, 575);
        this.frame.setDefaultCloseOperation(3);
        this.frame.getContentPane().setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        this.frame.getContentPane().add((Component)panel, "North");
        panel.setLayout(new GridLayout(9, 2));
        panel.add(new JLabel("First Name:"));
        this.firstNameField = new JTextField();
        panel.add(this.firstNameField);
        panel.add(new JLabel("Last Name:"));
        this.lastNameField = new JTextField();
        panel.add(this.lastNameField);
        panel.add(new JLabel("Job Title:"));
        this.jobTitleField = new JTextField();
        panel.add(this.jobTitleField);
        panel.add(new JLabel("Phone Number:"));
        this.telField = new JTextField();
        panel.add(this.telField);
        panel.add(new JLabel("Email id (Everything before the @):"));
        this.emailField = new JTextField();
        panel.add(this.emailField);
        panel.add(new JLabel("Linkedin (after linkedin.com/in/):"));
        this.urlField = new JTextField();
        panel.add(this.urlField);
        panel.add(new JLabel("Office Location (Abbreviations accepted):"));
        this.officeField = new JTextField();
        panel.add(this.officeField);
        JButton btnGenerate = new JButton("Generate QR Code");
        btnGenerate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                QRCodeGenerator.this.generateQRCode(3000);
            }
        });
        panel.add(btnGenerate);
        this.qrLabel = new JLabel("");
        this.frame.getContentPane().add((Component)this.qrLabel, "Center");
        JButton btnSave = new JButton("Save QR Code");
        btnSave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                QRCodeGenerator.this.saveQRCode();
            }
        });
        this.frame.getContentPane().add((Component)btnSave, "South");
    }

    private void generateQRCode(int size) {
        String firstName = this.firstNameField.getText();
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String lastName = this.lastNameField.getText();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        String organization = "SKA Consulting Engineers, Inc";
        String jobTitle = this.jobTitleField.getText();
        jobTitle = jobTitle.substring(0, 1).toUpperCase() + jobTitle.substring(1);
        String telephone = this.telField.getText();
        String emailId = this.emailField.getText();
        String email = emailId + "@skaeng.com";
        String url = this.urlField.getText();
        if (url.length() > 0) {
            url = "www.linkedin.com/in/" + url + "/";
        }
        String office = this.officeField.getText();
        String street = "";
        String city = "";
        String state = "";
        String postalCode = "";
        String country = "";
        if (office.toUpperCase().equals("CHARLOTTE") || office.toUpperCase().equals("CLT")) {
            street = "4651 Charlotte Park Drive, Suite 150";
            city = "Charlotte";
            state = "North Carolina";
            postalCode = "28217-1191";
            country = "United States";
        } else if (office.toUpperCase().equals("GREENSBORO") || office.toUpperCase().equals("GSO")) {
            street = "7900 Triad Center Drive, Suite 200";
            city = "Greensboro";
            state = "North Carolina";
            postalCode = "27409-9075";
            country = "United States";
        } else if (office.toUpperCase().equals("WILMINGTON") || office.toUpperCase().equals("ILM")) {
            street = "5911 Oleander Drive, Suite 100";
            city = "Wilmington";
            state = "North Carolina";
            postalCode = "28403";
            country = "United States";
        } else if (office.toUpperCase().equals("ASHEVILLE") || office.toUpperCase().equals("ASH")) {
            street = "409 Executive Park";
            city = "Asheville";
            state = "North Carolina";
            postalCode = "28801";
            country = "United States";
        } else if (office.toUpperCase().equals("RALEIGH") || office.toUpperCase().equals("DURHAM") || office.toUpperCase().equals("RALEIGH-DURHAM") || office.toUpperCase().equals("RDU")) {
            street = "100 Capitola Drive, Suite 109";
            city = "Durham";
            state = "North Carolina";
            postalCode = "27713";
            country = "United States";
        } else if (office.toUpperCase().equals("CHARLESTON") || office.toUpperCase().equals("CHS")) {
            street = "845 Lowcountry Boulevard, Suite P";
            city = "Mount Pleasant";
            state = "South Carolina";
            postalCode = "29464-3040";
            country = "United States";
        } else if (office.toUpperCase().equals("CHARLOTTESVILLE") || office.toUpperCase().equals("CHO")) {
            street = "2025 Woodbrook Court, Suite 2025";
            city = "Charlottesville";
            state = "Virginia";
            postalCode = "22901-1148";
            country = "United States";
        }
        else if (office.toUpperCase().equals("MOUNT PLEASANT") || office.toUpperCase().equals("MT P")) {
            street = "845 Lowcountry Boulevard, Suite P";
            city = "Mount Pleasant";
            state = "South Carolina";
            postalCode = "29464";
            country = "United States";
        }
        if (!(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty())) {
            String vCard = "BEGIN:VCARD\nVERSION:3.0\nFN:" + firstName + " " + lastName + "\nN:" + lastName + ";" + firstName + "\nORG:" + organization + "\nTITLE:" + jobTitle + "\nTEL:" + telephone + "\nEMAIL:" + email + "\nURL:" + url + "\nADR:;;" + street + ";" + city + ";" + state + ";" + postalCode + ";" + country + "\nEND:VCARD";
            HashMap<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            try {
                Color ska = Color.decode("#000066");
                BufferedImage overlayImage = null;
                BufferedImage scaledImage = new BufferedImage(300, 300, 1);
                try {
                    overlayImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/SKA only square.png"));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                BitMatrix bitMatrix = qrCodeWriter.encode(vCard, BarcodeFormat.QR_CODE, size, size, hintMap);
                this.qrImage = new BufferedImage(size, size, 1);
                Graphics2D graphics = this.qrImage.createGraphics();
                int overlayWidth = this.qrImage.getWidth() / 6;
                int overlayHeight = this.qrImage.getHeight() / 6;
                int newWidth = overlayWidth + 6;
                int newHeight = overlayHeight + 6;
                BufferedImage imageWithBorder = new BufferedImage(newWidth, newHeight, 1);
                Graphics2D g2d = imageWithBorder.createGraphics();
                g2d.setColor(ska);
                g2d.fillRect(0, 0, newWidth, newHeight);
                g2d.dispose();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, size, size);
                graphics.setColor(ska);
                for (int x = 0; x < size; ++x) {
                    for (int y = 0; y < size; ++y) {
                        if (!bitMatrix.get(x, y)) continue;
                        graphics.fillRect(x, y, 1, 1);
                    }
                }
                Graphics2D g2d3 = scaledImage.createGraphics();
                g2d3.drawImage(this.qrImage.getScaledInstance(300, 300, 4), 0, 0, null);
                g2d3.dispose();
                this.qrLabel.setIcon(new ImageIcon(scaledImage));
            }
            catch (WriterException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this.frame, "Please enter at least a first name, last name, and an email to generate the QR code.", "Input Error", 2);
        }
    }

    private void saveQRCode() {
        if (this.qrImage != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            int userSelection = fileChooser.showSaveDialog(this.frame);
            if (userSelection == 0) {
                File fileToSave = fileChooser.getSelectedFile();
                try {
                    ImageIO.write((RenderedImage)this.qrImage, "png", fileToSave);
                    JOptionPane.showMessageDialog(this.frame, "QR code saved successfully.", "Success", 1);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this.frame, "No QR code to save. Please generate one first.", "Save Error", 2);
        }
    }
}
