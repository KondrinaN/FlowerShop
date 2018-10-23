package com.accenture.flowershop.be.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionBD {
    public static Connection getOracleConnection() throws ClassNotFoundException, SQLException{
        String hostName = "127.0.0.1";
        String port = "1521";
        String sid = "XE"; //name of database
        String username = "SE";
        String password = "SE";

        return getOracleConnection(hostName, port, sid, username, password);
    }

    public static Connection getOracleConnection(String hostName, String port, String sid, String userName, String password) throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@" + hostName + ":" + port + ":"+ sid;

        Connection connection = DriverManager.getConnection(url, userName, password);

        return connection;
    }
}
