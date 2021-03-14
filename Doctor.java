import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Doctor {
    public static void main(String[] args) {
        JFrame f = new JFrame("Doctor's Panel");
        JTextField tf = new JTextField();
        JLabel l1 = new JLabel("Enter Your Appointment");
        JButton btn1 = new JButton("Add");
        // l1.setBounds(100, 100, 250, 40);
        // tf.setBounds(100, 150, 250, 40);
        // btn1.setBounds(380, 150, 100, 40);
        btn1.setPreferredSize(new Dimension(1, 4));

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText() != "") {
                    f.add(new JLabel(tf.getText()));
                    f.validate();
                    f.repaint();
                }

            }
        });

        f.add(l1);
        f.add(tf);
        f.add(btn1);

        f.setSize(1240, 662);
        f.setLayout(new GridLayout(10, 10));
        f.setVisible(true);
    }
}
