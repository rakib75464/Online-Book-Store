
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

public class Registration extends JFrame {
    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2, tf4, tf5;
    private JComboBox securityQsn;
    private JButton btn1, btn2, btn3, btn4, nBtn;
    private JPasswordField tf3;
    private Cursor cursor;
    private int a, b;

    Registration() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AIUB Online Book Shop");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#5AA5DB"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/logo1_5_50x50.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("/images/reg.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(70, 70, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Enter Your Information");
        label1.setBounds(430, 25, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("User Name");
        label1.setBounds(430, 75, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(570, 85, 260, 30);
        tf1.setFont(f5);
        c.add(tf1);

        // Email
        label1 = new JLabel();
        label1.setText("Email");
        label1.setBounds(430, 110, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JTextField();
        tf2.setBounds(570, 120, 260, 30);
        tf2.setFont(f5);
        c.add(tf2);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(430, 145, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf3 = new JPasswordField();
        tf3.setBounds(570, 155, 260, 30);
        tf3.setFont(f2);
        tf3.setEchoChar('*');
        c.add(tf3);

        // Question
        label1 = new JLabel();
        label1.setText("Question");
        label1.setBounds(430, 180, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        String[] secQsn = {"Choose a Security Question...", "Do you like to read?", "Your favorite Book?",
                "Favourite Writer?", "Purchased Before from us?"};
        securityQsn = new JComboBox(secQsn);
        securityQsn.setBounds(570, 190, 259, 30);
        securityQsn.setSelectedIndex(0);
        securityQsn.setFont(f5);
        securityQsn.setBackground(Color.white);
        c.add(securityQsn);

        // Answer
        label1 = new JLabel();
        label1.setText("Answer");
        label1.setBounds(430, 215, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf4 = new JTextField();
        tf4.setBounds(570, 225, 260, 30);
        tf4.setFont(f5);
        c.add(tf4);

        // Captcha Label and Text Field
        label1 = new JLabel();
        label1.setText("Captcha");
        label1.setBounds(430, 250, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf5 = new JTextField();
        tf5.setBounds(615, 260, 215, 30);
        tf5.setFont(f5);
        c.add(tf5);

        // To get a random number for captcha
        Random rand = new Random();
        int a = rand.nextInt(10);
        int b = rand.nextInt(10);

        // Captcha
        label1 = new JLabel();
        label1.setText(" " + a + " + " + b + " ");
        label1.setBounds(530, 260, 75, 30);
        label1.setFont(f4);
        label1.setForeground(Color.red);
        label1.setBackground(Color.decode("#FFD3D3"));
        label1.setOpaque(true);
        c.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(251, 325, 183, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(50, 15, 100, 40);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#C00000"));
        c.add(btn2);

        btn3 = new JButton("Reset");
        btn3.setBounds(450, 325, 183, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2B0EDB"));
        c.add(btn3);

        btn4 = new JButton("Register");
        btn4.setBounds(649, 325, 183, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#2B0EDB"));
        c.add(btn4);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });

        // Reset Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Registration frame = new Registration();
                frame.setVisible(true);
            }
        });
        //register btn
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("rg btn");
                String usrname = tf1.getText();
                String password = tf3.getText();
                String email=tf2.getText();


                //  System.out.println(usrname + password);

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
                        showMessageDialog(null, "Signup Successfully !");
                    }
                }else {
                    showMessageDialog(null, "User Password and Email empty");
                }
            }
        });



    }
}