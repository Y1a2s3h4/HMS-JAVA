import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Doctor {
    Doctor() {
        JFrame f = new JFrame("Doctor's Panel");
        JTextField doctorName = new JTextField();
        JTextField patientName = new JTextField();
        JTextField patientDisease = new JTextField();
        JTextField deleteAppoint = new JTextField();
        JTextField DT = new JTextField();
        JLabel l1 = new JLabel("Enter Your Appointment");
        JLabel docLabel = new JLabel("Doctor Name");
        JLabel PName = new JLabel("Patient Name");
        JLabel PDisease = new JLabel("Patient Disease");
        JLabel DateAndTime = new JLabel("Meeting Date & Time");
        JLabel IDNumber = new JLabel("Appointment ID");
        l1.setFont(new Font("Nirmala UI", 25, 48));
        JButton btn1 = new JButton("Add");
        JButton delButton = new JButton("Delete");
        JButton ShowData = new JButton("Show Appointments");
        JButton Bill = new JButton("Bill");
        JButton logout = new JButton("logout");
        System.out.println("Reached 1");
        Object column[] = { "ID", "Doctor Name", "Patient Name", "Disease", "Date & Time" };
        JTable jt = new JTable();
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        model.setColumnIdentifiers(column);
        jt.setModel(model);
        
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(700, 150, 390, 300);

        l1.setBounds(100, 10, 650, 100);
        docLabel.setBounds(100, 80, 650, 100);
        PName.setBounds(100, 180, 650, 100);
        PDisease.setBounds(100, 280, 650, 100);
        DateAndTime.setBounds(100, 380, 650, 100);
        IDNumber.setBounds(100, 480, 650, 100);
        doctorName.setBounds(100, 150, 250, 40);
        patientName.setBounds(100, 250, 250, 40);
        patientDisease.setBounds(100, 350, 250, 40);
        DT.setBounds(100, 450, 250, 40);
        deleteAppoint.setBounds(100, 550, 250, 40);
        btn1.setBounds(380, 450, 100, 40);
        delButton.setBounds(380, 550, 100, 40);
        ShowData.setBounds(200, 650, 200, 40);
        Bill.setBounds(450, 650, 100, 40);
        logout.setBounds(600, 650, 100, 40);
        System.out.println("Reached 2");


        sp.setVisible(false);
        ShowData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sp.setVisible(true);
                model.setRowCount(0);
                String insertAppoint = "SELECT * FROM doctorAppoint";
                System.out.println(insertAppoint);
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                    System.out.println("Connected SQL");

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(insertAppoint);
                    while(rs.next()){
                        String a_id = String.valueOf(rs.getInt("A_ID"));
                        String d_name = rs.getString("Doctor_Name");
                        String p_name = rs.getString("Patient_Name");
                        String p_disease = rs.getString("Patient_Disease");
                        String date_time = rs.getString("Date_Time");
                        String tData[] = {a_id, d_name, p_name, p_disease, date_time};
                    model.addRow(tData);
                    }
                    
                } catch (SQLException es) {
                    System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
                } catch (Exception eE) {
                    eE.printStackTrace();
                }
                JOptionPane.showMessageDialog(f, "Show");
            }
        });
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String insertAppoint = "INSERT INTO doctorAppoint (Doctor_Name, Patient_Name, Patient_Disease, Date_Time) VALUES(" +"'"+doctorName.getText()+"',"+ "'" + patientName.getText() + "'," + "'" + patientDisease.getText() + "'," + "'" + DT.getText() + "'" + " );";
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
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String delApp = "DELETE FROM doctorAppoint WHERE A_ID=" + deleteAppoint.getText();
                System.out.println(delApp);
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                    System.out.println("Connected SQL");

                    PreparedStatement ps = conn.prepareStatement(delApp);
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
                JOptionPane.showMessageDialog(f, "Deleted Row");
            }
        });
        Bill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Generate Bills");
                f.dispose();
                new Bill();
            }
        });
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Login();
                JOptionPane.showMessageDialog(f, "Logged Out");
            }
        });

        f.add(sp, BorderLayout.CENTER);

        f.add(l1);
        f.add(docLabel);
        f.add(PName);
        f.add(PDisease);
        f.add(IDNumber);
        f.add(DT);
        f.add(DateAndTime);
        f.add(doctorName);
        f.add(deleteAppoint);
        f.add(patientName);
        f.add(patientDisease);
        f.add(btn1);
        f.add(delButton);
        f.add(ShowData);
        f.add(Bill);
        f.add(logout);

        f.setSize(1240, 862);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Doctor();
    }
}


// javac Doctor.java && java -cp "F:\Degree\DSE\Java Labs\HMS Project\mysql-connector-java-8.0.23\mysql-connector-java-8.0.23.jar;F:\Degree\DSE\Java Labs\HMS Project" Doctor