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
import net.sf.javaml.core.Dataset;
import net.sf.javaml.sampling.Sampling;

/**
 *
 * @author nico
 */
public class Tester {
    public Dataset data;

    public Tester(Dataset data) {
        this.data = data;
    }
    
    
    
    public double teste(int sp) {
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
        return(double)count /(double)datas.y().size();
    }
}
    

