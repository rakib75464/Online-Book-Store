
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class AdminAdd extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2, tf4;
    private JComboBox securityQsn;
    private JButton btn1, btn2, nBtn;
    private JPasswordField tf3;
    private Cursor cursor;

    AdminAdd() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AIUB Online Book Shop");
        this.setSize(510, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#5AA5DB"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/logo1_5_50x50.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(100, 25, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("User Name");
        label1.setBounds(45, 75, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(185, 85, 260, 30);
        tf1.setFont(f5);
        c.add(tf1);

        // Email
        label1 = new JLabel();
        label1.setText("Email");
        label1.setBounds(45, 110, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JTextField();
        tf2.setBounds(185, 120, 260, 30);
        tf2.setFont(f5);
        c.add(tf2);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(45, 145, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf3 = new JPasswordField();
        tf3.setBounds(185, 155, 260, 30);
        tf3.setFont(f2);
        tf3.setEchoChar('*');
        c.add(tf3);

        // Question
        label1 = new JLabel();
        label1.setText("Question");
        label1.setBounds(45, 180, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        String[] secQsn = { "Choose a Security Question...", "Do you like to read?", "Your favorite Book?",
                "Favourite Writer?", "Purchased Before from us?"};
        securityQsn = new JComboBox(secQsn);
        securityQsn.setBounds(185, 190, 259, 30);
        securityQsn.setSelectedIndex(0);
        securityQsn.setFont(f5);
        securityQsn.setBackground(Color.white);
        c.add(securityQsn);

        // Answer
        label1 = new JLabel();
        label1.setText("Answer");
        label1.setBounds(45, 215, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf4 = new JTextField();
        tf4.setBounds(185, 225, 260, 30);
        tf4.setFont(f5);
        c.add(tf4);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Back");
        btn1.setBounds(51, 280, 183, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Add");
        btn2.setBounds(260, 280, 183, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2B0EDB"));
        c.add(btn2);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Back Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);
            }
        });

        // Register Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String usrname = tf1.getText();
                String password = tf3.getText();
                String email=tf2.getText();
                boolean BlankUserPass=usrname.isEmpty()==false && password.isEmpty()==false && email.isEmpty()==false;

                if(BlankUserPass)
                {
                    boolean valid_Status= Data.ValidateUser(usrname,password);

                    if(valid_Status){
                        //password  valid //user already exists
                        showMessageDialog(null, "User Already Exist");

                    }else {
                        Data.WriteUser(usrname,password,email); //don't use during login
                        //   Data d=new Data();
                        //  d.WriteUser(usrname,password);
                        showMessageDialog(null, "Added Successfully !");
                    }
                }else {
                    showMessageDialog(null, "User Password and Email empty");
                }
            }
        });
    }

}
