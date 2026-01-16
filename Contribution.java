
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Contribution extends JFrame
{
	private Container c;
	private ImageIcon icon, logo;
	private JLabel imgLabel;
    private Font f1;
    private JButton btn1;
    private Cursor cursor;
	
	Contribution() 
	{
		// Frame Layout
        this.setTitle("AIUB Online Book Shop");
        this.setSize(540, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		
		c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#5AA5DB"));
		
		// Icon
        icon = new ImageIcon(getClass().getResource("/images/logo1_5_50x50.png"));
        this.setIconImage(icon.getImage());
		
		// Logo and Images
        logo = new ImageIcon(getClass().getResource("D:/Final Project/pr.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(40, 20,logo.getIconWidth(), logo.getIconHeight() );  
        c.add(imgLabel);
		
		// Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 25);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
		// JButtons
        btn1 = new JButton("OK");
        btn1.setBounds(175, 580, 180, 50);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2B0EDB"));
        c.add(btn1);
		
		// Action Listener for JButtons
        // OK Button
        btn1.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent ae) 
			{
                setVisible(false);
				Welcome fram = new Welcome();
                fram.setVisible(true);
            }
        });
	}
}