import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Registration {
    Registration() {
        JFrame f = new JFrame("Registration");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel regDoctor, docNameLabel, mailLabel, passLabel, regPatient, paNameLabel, paPassLabel;
        JTextField docNameField, docMailField, patientNameField;
        JPasswordField docPassField, patientPassField;
        JButton registerDoctor, registerPatient;

        // Labels
        regDoctor = new JLabel("Register As Doctor");
        regDoctor.setBounds(20, 20, 600, 90);
        regDoctor.setFont(new Font("Nirmala UI", 25, 48));

        docNameLabel = new JLabel("Enter Your Name");
        docNameLabel.setBounds(20, 100, 600, 90);

        mailLabel = new JLabel("Enter Your Mail");
        mailLabel.setBounds(20, 200, 600, 90);

        passLabel = new JLabel("Enter Your Password");
        passLabel.setBounds(20, 300, 600, 90);

        regPatient = new JLabel("Register As Patient");
        regPatient.setBounds(520, 20, 600, 90);
        regPatient.setFont(new Font("Nirmala UI", 25, 48));

        paNameLabel = new JLabel("Enter Your Name");
        paNameLabel.setBounds(520, 100, 600, 90);

        paPassLabel = new JLabel("Enter Your Password");
        paPassLabel.setBounds(520, 200, 600, 90);

        // Text Fields
        docNameField = new JTextField();
        docNameField.setBounds(20, 170, 250, 40);

        docMailField = new JTextField();
        docMailField.setBounds(20, 270, 250, 40);

        docPassField = new JPasswordField();
        docPassField.setBounds(20, 370, 250, 40);

        patientNameField = new JTextField();
        patientNameField.setBounds(520, 170, 250, 40);

        patientPassField = new JPasswordField();
        patientPassField.setBounds(520, 270, 250, 40);

        // Button
        registerDoctor = new JButton("Register As Doctor");
        registerDoctor.setBounds(50, 450, 170, 40);

        registerPatient = new JButton("Register As Patient");
        registerPatient.setBounds(550, 350, 170, 40);

        // ActionListeners
        registerDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String doc_Name = "INSERT INTO doctorDetails (doc_name, doc_mail, doc_pass) VALUES(" + "'"
                        + docNameField.getText() + "'" + "," + "'" + docMailField.getText() + "'" + "," + "'"
                        + docPassField.getText() + "'" + " );";
                System.out.println(doc_Name);
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                    PreparedStatement ps = conn.prepareStatement(doc_Name);
                    // PreparedStatement ps = conn
                    // .prepareStatement("INSERT INTO doctorDetails (doc_name, doc_mail, doc_pass)
                    // VALUES("
                    // + docNameField + "," + docMailField + "," + docPassField + " );");
                    int status = ps.executeUpdate();
                    if (status != 0) {
                        System.out.println("DATABASE WAS Connected. Status is Greater than 0 ");
                    }
                    if (conn != null) {
                        System.out.println("Connected to the database!");
                    } else {
                        System.out.println("Failed to make connection!");
                    }

                } catch (SQLException es) {
                    System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
                } catch (Exception eE) {
                    eE.printStackTrace();
                }
                JOptionPane.showMessageDialog(f, "You Registered As Doctor.");
                f.dispose();
                new Login();
            }
        });

        registerPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientInsert = "INSERT INTO patientDetails (patient_name,  patient_pass) VALUES(" + "'"
                        + patientNameField.getText() + "'" + "," + "'" + patientPassField.getText() + "'" + " );";
                System.out.println(patientInsert);
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                    PreparedStatement ps = conn.prepareStatement(patientInsert);
                    int status = ps.executeUpdate();
                    if (status != 0) {
                        System.out.println("DATABASE WAS Connected. Status is Greater than 0 ");
                    }
                    if (conn != null) {
                        System.out.println("Connected to the database!");
                    } else {
                        System.out.println("Failed to make connection!");
                    }

                } catch (SQLException es) {
                    System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
                } catch (Exception eE) {
                    eE.printStackTrace();
                }
                JOptionPane.showMessageDialog(f, "You Registered As Patient.");
                f.dispose();
                new Login();
            }
        });

        // Adding Elements to Frame
        f.add(regDoctor);
        f.add(docNameLabel);
        f.add(mailLabel);
        f.add(passLabel);
        f.add(regPatient);
        f.add(paNameLabel);
        f.add(paPassLabel);
        f.add(docNameField);
        f.add(docMailField);
        f.add(docPassField);
        f.add(patientNameField);
        f.add(patientPassField);
        f.add(registerDoctor);
        f.add(registerPatient);

        f.setSize(1240, 662);
        f.setLayout(null);
        f.setVisible(true);

    }
}