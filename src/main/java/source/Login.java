package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    JFrame f = new JFrame("Dang nhap");
    JLabel userLabel, passLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    Login(Connection connection) {
        f.setSize(540, 360);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(100, 100, 80, 25);

        usernameField = new JTextField();
        usernameField.setBounds(200, 100, 200, 25);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(100, 150, 80, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 200, 25);

        loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLUE);
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
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Kết thúc ứng dụng khi đóng cửa sổ
            }
        });
        
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm logic xác thực đăng nhập ở đây
            try (Statement statement = connection.createStatement()) {
                String sql = "select * from ACCOUNT";
                    ResultSet rs;
                    boolean pass = false;
                    while (!pass) {
                        rs = statement.executeQuery(sql);
                        try {
                            while (rs.next()) {
                                String checkUser = rs.getString(2);
                                String checkPass = rs.getString(3);
                                if (checkUser.equals(username) && checkPass.equals(password)) {
                                    pass = true;
                                    System.out.println("Dang nhap thanh cong");
                                    break;
                                }
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        if (!pass) {
                            JOptionPane.showMessageDialog(null, "Username hoac password khong dung");
                        }
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        f.setVisible(true);
    }
}
