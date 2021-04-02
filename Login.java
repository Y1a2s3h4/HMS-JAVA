import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login {
    static JFrame f = new JFrame("Login");
    Login() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel loginDoc, docNameLabel, passLabel, loginPatient, paNameLabel, paPassLabel;
        JTextField docNameField, patientNameField;
        JPasswordField docPassField, patientPassField;
        JButton docLoginBtn, patientLoginBtn;

        // Labels
        loginDoc = new JLabel("Login As Doctor");
        loginDoc.setBounds(20, 20, 600, 90);
        loginDoc.setFont(new Font("Nirmala UI", 25, 48));

        docNameLabel = new JLabel("Enter Your Name");
        docNameLabel.setBounds(20, 100, 600, 90);

        passLabel = new JLabel("Enter Your Password");
        passLabel.setBounds(20, 200, 600, 90);

        loginPatient = new JLabel("Login As Patient");
        loginPatient.setBounds(520, 20, 600, 90);
        loginPatient.setFont(new Font("Nirmala UI", 25, 48));

        paNameLabel = new JLabel("Enter Your Name");
        paNameLabel.setBounds(520, 100, 600, 90);

        paPassLabel = new JLabel("Enter Your Password");
        paPassLabel.setBounds(520, 200, 600, 90);

        // Text Fields
        docNameField = new JTextField();
        docNameField.setBounds(20, 170, 250, 40);

        docPassField = new JPasswordField();
        docPassField.setBounds(20, 270, 250, 40);

        patientNameField = new JTextField();
        patientNameField.setBounds(520, 170, 250, 40);

        patientPassField = new JPasswordField();
        patientPassField.setBounds(520, 270, 250, 40);

        // Button
        docLoginBtn = new JButton("Log In As Doctor");
        docLoginBtn.setBounds(50, 350, 170, 40);

        patientLoginBtn = new JButton("Log In As Patient");
        patientLoginBtn.setBounds(550, 350, 170, 40);

        // ActionListeners
        docLoginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String loginQuery = "SELECT * FROM doctordetails where doc_name='"+docNameField.getText()+"' and doc_pass='"+docPassField.getText()+"'";
                System.out.println(loginQuery);
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(loginQuery);
                        while(rs.next()){
                            String n = rs.getString("doc_name");
                            String p = rs.getString("doc_pass");
                                JOptionPane.showMessageDialog(f, "Succussfully Logged In");
                                f.dispose();
                                new Doctor();
                        }
                } catch (SQLException es) {
                    System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
                } catch (Exception eE) {
                    eE.printStackTrace();
                }
            }
        });

        patientLoginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String loginQuery = "SELECT * FROM patientdetails where patient_name='"+patientNameField.getText()+"' and patient_pass='"+patientPassField.getText()+"'";
                System.out.println(loginQuery);
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(loginQuery);
                        while(rs.next()){
                            String n = rs.getString("patient_name");
                            String p = rs.getString("patient_pass");
                                JOptionPane.showMessageDialog(f, "Succussfully Logged In");
                                f.dispose();
                                new Patient(patientNameField.getText());
                        }
                } catch (SQLException es) {
                    System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
                } catch (Exception eE) {
                    eE.printStackTrace();
                }
            }
        });

        // Adding Elements to Frame
        f.add(loginDoc);
        f.add(docNameLabel);
        f.add(passLabel);
        f.add(loginPatient);
        f.add(paNameLabel);
        f.add(paPassLabel);
        f.add(docNameField);
        f.add(docPassField);
        f.add(patientNameField);
        f.add(patientPassField);
        f.add(docLoginBtn);
        f.add(patientLoginBtn);

        f.setSize(970, 662);
        f.setLayout(null);
        f.setVisible(true);

    }
    public static void main(String[] args) {
        new Login();
    }
}
// javac LandingPage.java && java -cp "F:\Degree\DSE\Java Labs\HMS Project\mysql-connector-java-8.0.23\mysql-connector-java-8.0.23.jar;F:\Degree\DSE\Java Labs\HMS Project" LandingPage