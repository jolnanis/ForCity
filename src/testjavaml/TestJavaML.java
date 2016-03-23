/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavaml;
 

import java.io.IOException;
import net.sf.javaml.core.Dataset;

/**
 *
 * @author nico
 */
public class TestJavaML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataBase.init();
        Dataset data = DataBase.load();
        Tester test = new Tester(data);
        System.out.println(test.teste(12));
        DataBase.shut();
    }
}