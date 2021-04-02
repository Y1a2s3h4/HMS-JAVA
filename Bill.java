import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Bill {
    Bill(){
        JFrame f = new JFrame("Bill Panel");

        JLabel l1 = new JLabel("Genrate Bills For Patients");
        l1.setBounds(150, 50, 600, 50);
        l1.setFont(new Font("Nirmala UI", 25, 48));


        JLabel docLabel = new JLabel("Doctor Name");
        docLabel.setBounds(150, 120, 100, 50);
        JTextField doctorName = new JTextField();
        doctorName.setBounds(150, 180, 250, 40);

        JLabel PName = new JLabel("Patient Name");        
        PName.setBounds(150, 220, 100, 50);
        JTextField patientName = new JTextField();        
        patientName.setBounds(150, 280, 250, 40);

        JLabel PDisease = new JLabel("Patient Disease");        
        PDisease.setBounds(150, 320, 100, 50);
        JTextField patientDisease = new JTextField();       
        patientDisease.setBounds(150, 380, 250, 40);

        JLabel tBill = new JLabel("Total Bill");        
        tBill.setBounds(150, 420, 100, 50);
        JTextField billField = new JTextField();       
        billField.setBounds(150, 480, 250, 40);

        JLabel last_date = new JLabel("Due For Paying Bill");        
        last_date.setBounds(150, 520, 150, 50);
        JTextField due_date = new JTextField();       
        due_date.setBounds(150, 580, 250, 40);
        

        JButton gen = new JButton("Generate Now");
        gen.setBounds(250, 650, 250, 40);


        gen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String insertAppoint = "INSERT INTO patientAppoint (Patient_Name, Patient_Disease, treatment_by, bill, payBy) VALUES("+ "'" + patientName.getText() + "','" + patientDisease.getText() + "','"+doctorName.getText()+"','"+billField.getText()+"','"+due_date.getText()+"');";
                System.out.println(insertAppoint);
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                    System.out.println("Connected SQL");

                    PreparedStatement ps = conn.prepareStatement(insertAppoint);
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
                JOptionPane.showMessageDialog(f, "New Appointment Added");
            }
        });




        f.add(l1);

        f.add(docLabel);
        f.add(PName);

        f.add(doctorName);
        f.add(patientName);

        f.add(PDisease);
        f.add(patientDisease);

        f.add(tBill);
        f.add(billField);

        f.add(last_date);
        f.add(due_date);

        f.add(gen);


        f.setSize(1240, 862);
        f.setLayout(null);
        f.setVisible(true);
    }
}
