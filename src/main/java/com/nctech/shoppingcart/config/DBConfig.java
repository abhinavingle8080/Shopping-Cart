package com.nctech.shoppingcart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@Component
public class DBConfig {
    private String url = "jdbc:mysql://localhost:3306/shopping_cart-1";
    private String userName = "Abhi";
    private String password = "1289";
    public Connection getConnection() throws SQLException {

       return DriverManager.getConnection(url, userName, password);
    }
}
