package com.mycompany.jdbc_evidencias_sena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbc_evidencias_sena {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3307/bbdd_codificacion_ga7";
        String user ="root";
        String pass = "";
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
        
        } catch (SQLExcetion ex){
            Logger,getLogger(bbdd_codificacion_ga7.class.getName()).log(Level.SEVERE, null, ex) 
        }  
            
    }
}
