package dev.aubique.conj.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConnectionImpl {

    public static final List<String> VERB_TABLE_COLUMNS;
    public static final List<String> TENSE_TABLE_COLUMNS;
    public static final String VERB_TABLE_NAME;
    public static final String TENSE_TABLE_NAME;
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
        VERB_TABLE_NAME = properties.getProperty("db.verbTableName");
        TENSE_TABLE_NAME = properties.getProperty("db.tenseTableName");
        final String verbColumns = properties.getProperty("db.verbTableColumns");
        final String tenseColumns = properties.getProperty("db.tenseTableColumns");
        VERB_TABLE_COLUMNS = new ArrayList<>(Arrays.asList(verbColumns.split(",")));
        TENSE_TABLE_COLUMNS = new ArrayList<>(Arrays.asList(tenseColumns.split(",")));
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
