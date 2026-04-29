package com.mycompany.jdbc_evidencias_sena.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String url = "jdbc:mysql://localhost:3307/bbdd_codificacion_ga7";
    private static final String user = "root";
    private static final String pass = "";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}