package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class LazySingleton {
    private static LazySingleton Util = null;
    private LazySingleton() {}
    public static LazySingleton getUtil() {
        if (Util == null) {
            synchronized(LazySingleton.class) {
                Util = new LazySingleton();
            }
        }
        return Util;
    }
}

public class Util {

    private static final String userName = "root";
    private static final String password = "neh,ektynyjcnm_7621*";
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/base?serverTimezone=UTC";
    Connection connection = null;

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            System.out.println("Подключение установлено");
        } catch (SQLException e) {
            System.out.println("Подключение отсутствует");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
