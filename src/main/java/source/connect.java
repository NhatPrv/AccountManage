package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connect {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-ETR4RHO\\SQL:1433;databaseName=ACCOUNTMANAGE;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password = "123456789";
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Kết nối thành công");

            String sql = "select * from ACCOUNT";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.print("username:  " + rs.getString(1));
            }
            new Login(connection);
        } catch (Exception e) {
            System.out.println("Kết nối thất bại");
            e.printStackTrace();
        }
    }
}