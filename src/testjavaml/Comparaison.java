/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavaml;

import java.io.File;
import java.io.IOException;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

/**
 *
 * @author nico
 */
public class Comparaison {
    public static void comp() throws IOException{
                int sp = 10;
        int exp = 1000;
        Dataset data = FileHandler.loadDataset(new File("data/iris_data_set/iris.csv"),4,",");
        Tester testeur = new Tester(data);
        double avg = 0;
        for (int i = 0; i<10; i++){
            for (int k = 0;k<exp;k++){
                avg += testeur.teste((i+1)*15-1) /exp;
            }
            System.out.println(avg);
            avg = 0;
        }
    }
}
