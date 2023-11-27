package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    static JFrame f = new JFrame("Đăng nhập");
    JLabel userLabel, passLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    Login(Connection connection) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(540, 360);
        f.setLocationRelativeTo(null);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(100, 100, 80, 25);

        usernameField = new JTextField();
        usernameField.setBounds(200, 100, 200, 25);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(100, 150, 80, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 200, 25);

        loginButton = new JButton("Login");
        loginButton.setBackground(Color.GRAY);
        loginButton.setBounds(200, 250, 140, 50);

        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        loginButton.setFont(buttonFont);

        f.setLayout(null);
        f.add(userLabel);
        f.add(usernameField);
        f.add(passLabel);
        f.add(passwordField);
        f.add(loginButton);

        // Thêm lệnh khi đóng cửa sổ

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị username và password khi người dùng nhấn nút đăng nhập
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // Thêm logic xác thực đăng nhập ở đây
                try (Statement statement = connection.createStatement()) {
                    String sql = "SELECT * FROM ACCOUNT WHERE username = '" + username + "' AND password = '" + password + "'";
                    ResultSet rs = statement.executeQuery(sql);

                    if (rs.next()) {
                        System.out.println("Đăng nhập thành công");
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username hoặc password không đúng");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        f.setVisible(true);
    }
}
