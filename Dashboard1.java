
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard1 extends JFrame
{
    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel , label2;
    private Font f1, f2, f3;
    private JButton btn1, btn2, btn3, btn4, nBtn,btn5;;
    private Cursor cursor;

    Dashboard1(String usrname)
    {
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
        logo = new ImageIcon(getClass().getResource("/images/cat.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(30, 70, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Tahoma", Font.BOLD, 48);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 20);


        // Title
        label1 = new JLabel();
        label1.setText("Choose the");
        label1.setBounds(420, 55, 500, 65);
        label1.setFont(f1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("Catagory Of Books");
        label1.setBounds(420, 120, 500, 65);
        label1.setFont(f1);
        c.add(label1);

        label2 = new JLabel();
        label2.setText("Username :");
        label2.setBounds(582, 15, 150, 30);
        label2.setFont(f3);
        c.add(label2);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Story Book");
        btn1.setBounds(418, 214, 195, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2B0EDB"));
        c.add(btn1);

        btn2 = new JButton("Detective");
        btn2.setBounds(634, 214, 195, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2B0EDB"));
        c.add(btn2);

        btn3 = new JButton("Exit");
        btn3.setBounds(418, 288, 195, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#C00000"));
        c.add(btn3);

        btn4 = new JButton("Novels");
        btn4.setBounds(634, 288, 195, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#2B0EDB"));
        c.add(btn4);

        nBtn = new JButton("Back");
        nBtn.setBounds(50, 15, 100, 40);
        nBtn.setFont(f2);
        nBtn.setCursor(cursor);
        nBtn.setForeground(Color.WHITE);
        nBtn.setBackground(Color.decode("#C00000"));
        c.add(nBtn);

        btn5 = new JButton(usrname);
        btn5.setBounds (700, 15, 170, 30);
        btn5.setFont(f3);
        btn5.setCursor(cursor);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(Color.decode("#C00000"));
        c.add(btn5);



        // Exit
        btn3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        });

        // Back
        nBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                Login frame = new Login();
                frame.setVisible(true);
            }
        });

        // Story Book
        btn1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                StoryBook frame = new StoryBook(usrname);
                frame.setVisible(true);
            }
        });

        // Detective Book
        btn2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                Detective frame = new Detective(usrname);
                frame.setVisible(true);
            }
        });

        // Novels Book
        btn4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                Novels frame = new Novels(usrname);
                frame.setVisible(true);
            }
        });

    }
}