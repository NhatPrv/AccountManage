package source;

import javax.swing.*;
import java.awt.*;

public class LogForm {
    private JFrame f;
    private JButton login;
    private JLabel hello;

    LogForm() {
        f = new JFrame("Welcome");
        f.setSize(520, 360);
        f.setLocationRelativeTo(null);

        initComponents();

        f.setBackground(new Color(34, 139, 34));

        f.setVisible(true);
    }

    private void initComponents() {
        hello = new JLabel("Chao mung");
        hello.setBounds(160, 60, 200, 60);
        hello.setFont(new Font("Arial", Font.PLAIN, 32));

        login = new JButton("Login");
        login.setBounds(100, 150, 100, 70);
        login.setBackground(Color.GRAY);
        login.setFont(new Font("Arial", Font.PLAIN, 28));

        f.setLayout(null);
        f.add(hello);
        f.add(login);
    }
}
