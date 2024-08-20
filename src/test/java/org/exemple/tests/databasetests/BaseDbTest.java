package org.exemple.tests.databasetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDbTest {

    public Connection connection;
    public Statement statement;

    @BeforeEach
    void beforeEach() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/mem:testdb",

                "user", "pass");
        statement = connection.createStatement();
    }

    @AfterEach
    void afterEach() throws SQLException {
        connection.close();
    }
}
