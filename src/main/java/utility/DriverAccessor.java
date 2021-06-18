package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverAccessor {

    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // mysql8.0
    // 自分のユーザ名
    private final static String USER_NAME = "root";
    //自分のmysqlのパスワード
    private final static String PASSWORD = "root";

    public Connection createConnection() {
        String JAVA_ENV = System.getenv("JAVA_ENV");
        String DRIVER_URL = "jdbc:mysql://localhost:3306/db?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
        
        if (JAVA_ENV.equals("development")) {
            // 自分自身のPC内で　docker-compose　立ち上げ
            DRIVER_URL = "jdbc:mysql://local_springwork2000g0_db:3306/db?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
        } else if (JAVA_ENV.equals("production")) {
            // 本番環境
            DRIVER_URL = "jdbc:mysql://springwork2000g0_db:3306/db?allowPublicKeyRetrieval=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
        } else{
            // gradleなどで起動の場合
            DRIVER_URL = "jdbc:mysql://localhost:3306/db?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true"; 
        }
        try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Can't Find JDBC Driver.\n");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}