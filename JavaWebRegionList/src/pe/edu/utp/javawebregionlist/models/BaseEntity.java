package pe.edu.utp.javawebregionlist.models;

import java.sql.Connection;

public class BaseEntity {
    private String localhost;
    private String username;
    private String password;

    private Connection connection;


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
