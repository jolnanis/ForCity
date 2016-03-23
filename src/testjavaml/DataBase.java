/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavaml;



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import weka.core.SparseInstance;

/**
 *
 * @author nico
 */
public class DataBase {
    private static Connection con;
    private static final String dbURL = "jdbc:postgresql:test";    

    /**
     *
     */
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

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public static Dataset load(){
            Dataset data = new DefaultDataset();
            
            double[] tmpArray = new double[] {0,0,0,0};
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM iris_dataset");
            while (rs.next()){
                tmpArray[0] = rs.getDouble(1);
                tmpArray[1] = rs.getDouble(2);
                tmpArray[2] = rs.getDouble(3);
                tmpArray[3] = rs.getDouble(4);
                Instance tmpInstance = new DenseInstance(tmpArray, rs.getString(4));
                data.add(tmpInstance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return data;
    }
}
