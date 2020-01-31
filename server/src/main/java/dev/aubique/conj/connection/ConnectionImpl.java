package dev.aubique.conj.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionImpl {

    private static final String propertiesFileName = "db.properties";
    private static final String URL;
    private static final String PASSWD;
    private static final String DRIVER_CLASS_NAME;
    private static Properties properties;

    static {
        properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try {
            properties.load(loader.getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("db.url");
        PASSWD = properties.getProperty("db.passwd");
        DRIVER_CLASS_NAME = properties.getProperty("db.driverClassName");
    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            return DriverManager.getConnection(URL, PASSWD, PASSWD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not managed to find a class " + DRIVER_CLASS_NAME);
        } catch (SQLException e) {
            throw new RuntimeException("Connection error to " + URL);
        }
    }
}
