
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;
import java.util.List;

public class UserData extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5, nBtn;
    private Cursor cursor;

    private String[] column = {"User Name", "Password", "Email"};
    private String[] rows = new String[7];

    UserData() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AIUB Online Book Shop");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#5AA5DB"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/logo1_5_50x50.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("User Data");
        label1.setBounds(200, 10, 400, 80);
        label1.setFont(f1);
        c.add(label1);

        // JButtons
        btn1 = new JButton("Refresh");
        btn1.setBounds(54, 418, 184, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2B0EDB"));
        c.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(248, 418, 184, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2B0EDB"));
        c.add(btn2);

        btn3 = new JButton("Add");
        btn3.setBounds(442, 418, 184, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2B0EDB"));
        c.add(btn3);

        btn4 = new JButton("Exit");
        btn4.setBounds(54, 480, 278, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#C00000"));
        c.add(btn4);

        btn5 = new JButton("Back");
        btn5.setBounds(342, 480, 284, 50);
        btn5.setFont(f2);
        btn5.setCursor(cursor);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(Color.decode("#C00000"));
        c.add(btn5);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);

        scroll = new JScrollPane(table);
        scroll.setBounds(53, 96, 578, 300);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        // Append a row
        // model.addRow(new Object[]{"user", "pass","id"});

        //read file line by line
        try
        {
            File file=new File(".\\Data\\user_db.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            // StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;

            while((line=br.readLine())!=null)
            {

                //   System.out.println(line);

                String user =line.split(":")[0];
                String pass = line.split(":")[1];
                String email = line.split(":")[2];

                //System.out.println(user+" " +pass+" "+email);
                //set details   in table
                model.addRow(new Object[]{user,pass,email});
            }
            // fr.close();    //closes the stream and release the resources

            // System.out.println(isvalid);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        // Refresh Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);

            }
        });


        // Add Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminAdd frame = new AdminAdd();
                frame.setVisible(true);
            }
        });

        // Exit Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Admin frame = new Admin();
                frame.setVisible(true);
            }
        });

        //delete btn

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //first get koren user ,pass ,mail


                int row = table.getSelectedRow();
                String user = table.getModel().getValueAt(row, 0).toString();
                String pass = table.getModel().getValueAt(row, 1).toString();
                String email = table.getModel().getValueAt(row, 2).toString();

                //System.out.println(user+pass+email);
                Data.DeleteUser(user,pass,email);

                //refresh
                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);


            }
        });

    }

}
