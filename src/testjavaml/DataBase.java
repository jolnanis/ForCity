/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavaml;



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico
 */
public class DataBase {
    private static Connection con;
    private static final String dbURL = "jdbc:postgresql:test";    
    public static void init(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException:");
            System.err.println(e.getMessage());
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            con = DriverManager.getConnection(dbURL, "nico", "password");
        } catch (SQLException ex) {
            System.err.println("SQLException");
            System.err.println(ex.getMessage());
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void shut(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Driver theDriver = DriverManager.getDriver(dbURL);
            DriverManager.deregisterDriver(theDriver);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
