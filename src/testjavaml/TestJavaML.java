/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavaml;

import be.abeel.util.Pair;
import java.io.File;
import java.io.IOException;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.sampling.Sampling;
import net.sf.javaml.tools.data.FileHandler;

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
        Dataset data = FileHandler.loadDataset(new File("iris_data_set/iris.csv"),4,",");
        Sampling s=Sampling.SubSampling;
        Pair<Dataset, Dataset> datas = s.sample(data, 25);
        Clusterer c = new KMeans(4);
        Dataset[] clusters;
        clusters = c.cluster(data);
        for (int i=0;i<4;i++){
            System.out.println(clusters[i]);
        }
    }
}
