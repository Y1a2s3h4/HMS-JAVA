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
