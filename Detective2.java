
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Detective2 extends JFrame
{
    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private JButton btn1, btn2, btn3, btn4, nBtn,btn5;;
    private Cursor cursor;
    private JRadioButton sb1, sb2, sb3;
    private ButtonGroup jButtonGroup;
    private int sb = 0;

    Detective2(String usrname)
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
        logo = new ImageIcon(getClass().getResource("/images/dec2.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(0, 0, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 40);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 30);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        nBtn = new JButton("Back");
        nBtn.setBounds(50, 15, 100, 40);
        nBtn.setFont(f2);
        nBtn.setCursor(cursor);
        nBtn.setForeground(Color.WHITE);
        nBtn.setBackground(Color.decode("#C00000"));
        c.add(nBtn);


        btn1 = new JButton("Buy");
        btn1.setBounds(750, 15, 100, 40);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2B0EDB"));
        c.add(btn1);



        jButtonGroup = new ButtonGroup();
        jButtonGroup.add(sb1);
        jButtonGroup.add(sb2);
        jButtonGroup.add(sb3);

        sb1 = new JRadioButton("450 tk");
        sb1.setBounds(110, 340, 120, 40);
        sb1.setFont(f2);
        sb1.setCursor(cursor);
        sb1.setBackground(Color.decode("#e2af00"));
        c.add(sb1);

        sb2 = new JRadioButton("330 tk");
        sb2.setBounds(380, 340, 120, 40);
        sb2.setFont(f2);
        sb2.setCursor(cursor);
        sb2.setBackground(Color.decode("#e2af00"));
        c.add(sb2);

        sb3 = new JRadioButton("400 tk");
        sb3.setBounds(650, 340, 120, 40);
        sb3.setFont(f2);
        sb3.setCursor(cursor);
        sb3.setBackground(Color.decode("#e2af00"));
        c.add(sb3);

        Handler handler = new Handler();
        sb1.addActionListener(handler);
        sb2.addActionListener(handler);
        sb3.addActionListener(handler);


        nBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                Detective frame = new Detective(usrname);
                frame.setVisible(true);
            }
        });


        // Buy Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (sb == 1) {
                    setVisible(false);
                    Buy frame = new Buy(usrname);
                    frame.setVisible(true);
                } else if (sb == 2) {
                    setVisible(false);
                    Buy frame = new Buy(usrname);
                    frame.setVisible(true);
                }
                else if (sb == 3) {
                    setVisible(false);
                    Buy frame = new Buy(usrname);
                    frame.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select any Book! :(", "Warming!!!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });




    }

    class Handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sb1)
            {
                sb = 1;
            }
            else if (e.getSource() == sb2)
            {
                sb = 2;
            }
            else if(e.getSource() == sb3)
            {
                sb = 3;
            }

        }
    }

}