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
import net.sf.javaml.classification.tree.RandomForest;
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
        int sp = 10;
        Dataset data = FileHandler.loadDataset(new File("iris_data_set/iris.csv"),4,",");
        Sampling s=Sampling.SubSampling;
        Pair<Dataset, Dataset> datas = s.sample(data, sp);
        Classifier c = new RandomForest(10);
        c.buildClassifier(datas.x());
        int count = 0;
        for(int i = 0;i<datas.y().size();i++){
            if (c.classify(datas.y().get(i)).equals(datas.y().get(i).classValue())){
                count++;
            }    
        }
        System.out.println((double)count /(double)datas.y().size());
        
        
    }
}
