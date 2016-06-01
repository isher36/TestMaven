package jdcb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 * Created by isher on 31/05/2016.
 */
public class JdbcManager {

    // GETTER/SETTER
    Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/hb_cours";
    private String user = "admin";
    private String passwd = "300181";

    // Constructor
    public JdbcManager() {
    }

    public JdbcManager(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * Get Connection , Open JDBC Connection if null
     */
    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * Close jdbc connection
     */
    public void closeConnection() {
        try {
            this.connection.close();
            this.connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getStatement(String request, String[] param) {
        return getStatement(getConnection(), request, param);
    }

    /**
     * return Resultset of sql request
     *
     * @param connection
     * @param request
     * @param param      String parameter as Array
     * @return
     */
    public ResultSet getStatement(Connection connection, String request, String[] param) {
        try {
            // on prepare la requete
            PreparedStatement preparedStatement = connection.prepareStatement(request, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // on set les parametres
            int i = 1;
            for (String p : param) {
                preparedStatement.setString(i, p);
            }
            preparedStatement.execute();
            return preparedStatement.getResultSet();


        } catch (SQLException e) {
            e.toString();
        }
        return null;
    }
}
