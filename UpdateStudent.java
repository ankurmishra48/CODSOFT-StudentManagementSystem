import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
    
    JTextField stueducation, stufname, stuaddress, stuphone, stuemail, stuclass, stubranch;
    JLabel lblstuId, lblaadhar, lblname;
    JButton update, back;
    String stuId;
    
    // Constructor accepting student ID
    UpdateStudent(String stuId) {
        this.stuId = stuId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        stufname = new JTextField();
        stufname.setBounds(600, 150, 150, 30);
        add(stufname);
        
        JLabel labelclass = new JLabel("Class");
        labelclass.setBounds(400, 200, 150, 30);
        labelclass.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelclass);
        
        stuclass = new JTextField();
        stuclass.setBounds(600, 200, 150, 30);
        add(stuclass);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 200, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        stuaddress = new JTextField();
        stuaddress.setBounds(200, 200, 150, 30);
        add(stuaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        stuphone = new JTextField();
        stuphone.setBounds(200, 250, 150, 30);
        add(stuphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(400, 250, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        stuemail = new JTextField();
        stuemail.setBounds(600, 250, 150, 30);
        add(stuemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(50, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        stueducation = new JTextField();
        stueducation.setBounds(200, 300, 150, 30);
        add(stueducation);
        
        JLabel labelbranch = new JLabel("Branch");
        labelbranch.setBounds(400, 300, 150, 30);
        labelbranch.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelbranch);
        
        stubranch = new JTextField();
        stubranch.setBounds(600, 300, 150, 30);
        add(stubranch);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(50, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        lblaadhar = new JLabel();
        lblaadhar.setBounds(200, 350, 150, 30);
        add(lblaadhar);
        
        JLabel labelstuId = new JLabel("Student ID");
        labelstuId.setBounds(400, 350, 150, 30);
        labelstuId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstuId);
        
        lblstuId = new JLabel();
        lblstuId.setBounds(600, 350, 150, 30);
        lblstuId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblstuId);
        
        // Fetch and display existing student details
        try {
            Conn c = new Conn();
            String query = "select * from student where stuId = '" + stuId + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                stufname.setText(rs.getString("fname"));
                stuaddress.setText(rs.getString("address"));
                stuclass.setText(rs.getString("class"));
                stuphone.setText(rs.getString("phone"));
                stuemail.setText(rs.getString("email"));
                stueducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblstuId.setText(rs.getString("stuId"));
                stubranch.setText(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        update = new JButton("Update Details");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        
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
        if (ae.getSource() == update) {
            String fname = stufname.getText();
            String classs = stuclass.getText();
            String address = stuaddress.getText();
            String phone = stuphone.getText();
            String email = stuemail.getText();
            String education = stueducation.getText();
            String branch = stubranch.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update student set fname = '"+fname+"', class = '"+classs+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', branch= '"+branch+"' where stuId = '"+stuId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateStudent("EnterStudentIDHere"); // Pass the actual student ID here
    }
}
