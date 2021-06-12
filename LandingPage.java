import java.sql.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LandingPage {
    static JFrame f;

    public static void main(String[] args) {
        f = new JFrame("Landing");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1, l2, l3;

        JButton btnReg = new JButton("Register");
        JButton btnLogin = new JButton("Login");

        btnReg.setBounds(20, 310, 125, 31);
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Registration");
                f.dispose();
                new Registration();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Login");
                f.dispose();
                new Login();
            }
        });

        btnLogin.setBounds(150, 310, 125, 31);
        btnReg.setFont(new Font("Tahoma", 0, 14));

        l1 = new JLabel("Health City");
        l1.setFont(new Font("Impact", 1, 80));
        l1.setBounds(20, 110, 383, 98);
        l2 = new JLabel("Management System");
        l2.setFont(new Font("Open Sans", 1, 50));
        l2.setBounds(20, 190, 525, 98);

        f.add(l1);
        f.add(l2);
        f.add(btnReg);
        f.add(btnLogin);
        f.setSize(1240, 662);
        f.setLayout(null);
        f.setVisible(true);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root", "Yash123_$")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

// javac LandingPage.java && java -cp "F:\Degree\DSE\Java Labs\HMS Project\mysql-connector-java-8.0.23\mysql-connector-java-8.0.23.jar;F:\Degree\DSE\Mini Project\HMS Project" LandingPage