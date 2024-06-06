import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField sfname, slname, saddress, sphone, saadhar, semail, sclass, sbranch;
  //  JDateChooser dcdob;
    JComboBox<String> cbeducation;
    JLabel lblstuId;
    JButton add, back;

    AddStudent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Student Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        sfname = new JTextField();
        sfname.setBounds(200, 150, 150, 30);
        add(sfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        slname = new JTextField();
        slname.setBounds(600, 150, 150, 30);
        add(slname);

        JLabel labelsalary = new JLabel("Class");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        sclass = new JTextField();
        sclass.setBounds(600, 200, 150, 30);
        add(sclass);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 200, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        saddress = new JTextField();
        saddress.setBounds(200, 200, 150, 30);
        add(saddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        sphone = new JTextField();
        sphone.setBounds(600, 250, 150, 30);
        add(sphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 250, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        semail = new JTextField();
        semail.setBounds(200, 250, 150, 30);
        add(semail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String[] courses = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox<>(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);

        JLabel labeldesignation = new JLabel("Branch");
        labeldesignation.setBounds(50, 300, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        sbranch = new JTextField();
        sbranch.setBounds(200, 300, 150, 30);
        add(sbranch);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        saadhar = new JTextField();
        saadhar.setBounds(600, 350, 150, 30);
        add(saadhar);

        JLabel labelstuId = new JLabel("Student ID");
        labelstuId.setBounds(50, 350, 150, 30);
        labelstuId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstuId);

        lblstuId = new JLabel("" + number);
         lblstuId.setBounds(200, 350, 150, 30);
        lblstuId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblstuId);

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = sfname.getText();
            String fname = slname.getText();
            //String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String classs = sclass.getText();
            String address = saddress.getText();
            String phone = sphone.getText();
            String email = semail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String branch = sbranch.getText();
            String aadhar = saadhar.getText();
            String stuId = lblstuId.getText();

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO student (name, fname, class, address, phone, email, education, branch, aadhar, stuId) VALUES ('"+name+"', '"+fname+"','"+classs+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+branch+"', '"+aadhar+"', '"+stuId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error adding details");
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
