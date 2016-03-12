/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavaml;
 

import java.io.IOException;

/**
 *
 * @author nico
 */
public class TestJavaML {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        DataBase.init();
        
        DataBase.shut();
    }
}