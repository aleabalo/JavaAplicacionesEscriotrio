/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author ale
 */
public class iniciarConexion {
   
    
    public static Connection  getConection () throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
      return con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Obli_RRHH", "root", "password");
    }
    
}
