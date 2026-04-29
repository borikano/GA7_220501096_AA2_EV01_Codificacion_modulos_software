package com.mycompany.jdbc_evidencias_sena;

import com.mycompany.jdbc_evidencias_sena.config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class Jdbc_evidencias_sena {

    public static void main(String[] args) {

        try (Connection conexion = Conexion.obtenerConexion()) {

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos bbdd_codificacion_ga7.");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            System.out.println("Detalle del error: " + e.getMessage());
        }
    }
}
