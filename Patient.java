import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Patient{
    Patient(String pname){
        JFrame f = new JFrame("Patient's Panel");
        JButton logout = new JButton("Logout");
        JLabel Patient_Name = new JLabel("Patient Name: Currently Not Available ");
        JLabel Treatment_Doc = new JLabel("Treatment By: Currently Not Available ");
        JLabel Teatment_For = new JLabel("Treatment For: Currently Not Available ");
        JLabel Fees = new JLabel("Fees: Currently Not Available ");
        JLabel due = new JLabel("Due Date: Currently Not Available ");

        Patient_Name.setBounds(20,50,250,50);
        Treatment_Doc.setBounds(20,100,250,50);
        Teatment_For.setBounds(20,150,250,50);
        Fees.setBounds(20,200,250,50);
        due.setBounds(20,250,250,50);
        logout.setBounds(20,300,200,50);



        String loginQuery = "SELECT * FROM patientAppoint where Patient_Name='"+pname+"'";
                System.out.println(loginQuery);
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
                        "Yash123_$")) {
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(loginQuery);
                System.out.println(loginQuery);

                        while(rs.next()){
                            String n = rs.getString("Patient_Name");
                            String pd = rs.getString("Patient_Disease");
                            String d = rs.getString("treatment_by");
                            String b = rs.getString("bill");
                            String de = rs.getString("payBy");
                            System.out.println("reach");
                            System.out.println(n);
                            Patient_Name.setText("Patient Name: "+n);
                            Treatment_Doc.setText("Treatment By: "+d);
                            Teatment_For.setText("Treatment For: "+pd);
                            Fees.setText("Bill: "+b);
                            due.setText("Due Date: "+de);
                        }
                } catch (SQLException es) {
                    System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
                } catch (Exception eE) {
                    eE.printStackTrace();
                }

                logout.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Logged Out");
                        f.dispose();
                        new Login();
                    }
                });



        f.add(logout);
        f.add(Patient_Name);
        f.add(Treatment_Doc);
        f.add(Teatment_For);
        f.add(Fees);
        f.add(due);
        f.setSize(800, 662);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Patient("yash");
    }
}





// public class Patient {
//     Patient() {
//         JFrame f = new JFrame("Patient's Panel");
//         JTextField patientName = new JTextField();
//         JTextField patientDisease = new JTextField();
//         JTextField deleteAppoint = new JTextField();
//         JTextField DT = new JTextField();
//         JLabel l1 = new JLabel("Enter Your Appointment");
//         JLabel PName = new JLabel("Patient Name");
//         JLabel PDisease = new JLabel("Patient Disease");
//         JLabel DateAndTime = new JLabel("Meeting Date & Time");
//         JLabel IDNumber = new JLabel("Appointment ID");
//         l1.setFont(new Font("Nirmala UI", 25, 48));
//         JButton btn1 = new JButton("Add");
//         JButton delButton = new JButton("Delete");
//         JButton ShowData = new JButton("Show Appointments");
//         System.out.println("Reached 1");
//         Object column[] = { "ID", "Patient Name", "Disease", "Date & Time" };
//         // DefaultTableModel model = new DefaultTableModel();
//         JTable jt = new JTable();
//         DefaultTableModel model = (DefaultTableModel) jt.getModel();
//         model.setColumnIdentifiers(column);
//         jt.setModel(model);
        
//         JScrollPane sp = new JScrollPane(jt);
//         sp.setBounds(700, 150, 390, 300);

//         l1.setBounds(100, 10, 650, 100);
//         PName.setBounds(100, 80, 650, 100);
//         PDisease.setBounds(100, 180, 650, 100);
//         DateAndTime.setBounds(100, 280, 650, 100);
//         IDNumber.setBounds(100, 380, 650, 100);
//         patientName.setBounds(100, 150, 250, 40);
//         patientDisease.setBounds(100, 250, 250, 40);
//         DT.setBounds(100, 350, 250, 40);
//         deleteAppoint.setBounds(100, 450, 250, 40);
//         btn1.setBounds(380, 150, 100, 40);
//         delButton.setBounds(380, 450, 100, 40);
//         ShowData.setBounds(480, 550, 200, 40);
//         System.out.println("Reached 2");


//         sp.setVisible(false);
//         ShowData.addActionListener(new ActionListener(){
//             public void actionPerformed(ActionEvent e){
//                 sp.setVisible(true);
//                 model.setRowCount(0);
//                 String insertAppoint = "SELECT * FROM doctorAppoint";
//                 System.out.println(insertAppoint);
//                         try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
//                         "Yash123_$")) {
//                     System.out.println("Connected SQL");

//                     Statement stmt = conn.createStatement();
//                     ResultSet rs = stmt.executeQuery(insertAppoint);
//                     while(rs.next()){
//                         String a_id = String.valueOf(rs.getInt("A_ID"));
//                         String p_name = rs.getString("Patient_Name");
//                         String p_disease = rs.getString("Patient_Disease");
//                         String date_time = rs.getString("Date_Time");
//                         String tData[] = {a_id, p_name, p_disease, date_time};
//                     model.addRow(tData);
//                     }
                    
//                     // if (status != "") {
//                     //     System.out.println("DATABASE WAS Connected. Status is Greater than 0 ");
//                     // }
//                     // if (conn != null) {
//                     //     System.out.println("Connected to the database!");
//                     // } else {
//                     //     System.out.println("Failed to make connection!");
//                     // }

//                 } catch (SQLException es) {
//                     System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
//                 } catch (Exception eE) {
//                     eE.printStackTrace();
//                 }
//                 JOptionPane.showMessageDialog(f, "Show");
//             }
//         });
//         btn1.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String insertAppoint = "INSERT INTO doctorAppoint (Patient_Name, Patient_Disease, Date_Time) VALUES("
//                 + "'" + patientName.getText() + "'" + "," + "'" + patientDisease.getText() + "'" + "," + "'" + DT.getText() + "'" + " );";
//                 System.out.println(insertAppoint);
//                         try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
//                         "Yash123_$")) {
//                     System.out.println("Connected SQL");

//                     PreparedStatement ps = conn.prepareStatement(insertAppoint);
//                     int status = ps.executeUpdate();
//                     if (status != 0) {
//                         System.out.println("DATABASE WAS Connected. Status is Greater than 0 ");
//                     }
//                     if (conn != null) {
//                         System.out.println("Connected to the database!");
//                     } else {
//                         System.out.println("Failed to make connection!");
//                     }

//                 } catch (SQLException es) {
//                     System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
//                 } catch (Exception eE) {
//                     eE.printStackTrace();
//                 }
//                 JOptionPane.showMessageDialog(f, "New Appointment Added");
//             }
//         });
//         delButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String delApp = "DELETE FROM doctorAppoint WHERE A_ID=" + deleteAppoint.getText();
//                 System.out.println(delApp);
//                         try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms_db", "root",
//                         "Yash123_$")) {
//                     System.out.println("Connected SQL");

//                     PreparedStatement ps = conn.prepareStatement(delApp);
//                     int status = ps.executeUpdate();
//                     if (status != 0) {
//                         System.out.println("DATABASE WAS Connected. Status is Greater than 0 ");
//                     }
//                     if (conn != null) {
//                         System.out.println("Connected to the database!");
//                     } else {
//                         System.out.println("Failed to make connection!");
//                     }

//                 } catch (SQLException es) {
//                     System.err.format("SQL State: %s\n%s", es.getSQLState(), es.getMessage());
//                 } catch (Exception eE) {
//                     eE.printStackTrace();
//                 }
//                 JOptionPane.showMessageDialog(f, "Deleted Row");
//             }
//         });

//         f.add(sp, BorderLayout.CENTER);

//         f.add(l1);
//         f.add(PName);
//         f.add(PDisease);
//         f.add(IDNumber);
//         f.add(DT);
//         f.add(DateAndTime);
//         f.add(deleteAppoint);
//         f.add(patientName);
//         f.add(patientDisease);
//         f.add(btn1);
//         f.add(delButton);
//         f.add(ShowData);

//         f.setSize(1240, 662);
//         f.setLayout(null);
//         f.setVisible(true);
//     }

    // public static void main(String[] args) {
    //     new Patient();
    // }
// }


// // javac Doctor.java && java -cp "F:\Degree\DSE\Java Labs\HMS Project\mysql-connector-java-8.0.23\mysql-connector-java-8.0.23.jar;F:\Degree\DSE\Java Labs\HMS Project" Doctor