package com.hml.weka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import utils.PrintUtils;
import utils.PropertyUtils;
import weka.clusterers.SimpleKMeans;
import weka.core.DistanceFunction;
import weka.core.Instance;
import weka.core.Instances;

public class WekaKmeansDriver {

	public void runKMeans(int numClusters){
		try {
			SimpleKMeans kmeans = new SimpleKMeans();
			
			//DistanceFunction df = new weka.core.ManhattanDistance();
			DistanceFunction df = new weka.core.EuclideanDistance();
			
			kmeans.setDistanceFunction(df);
			kmeans.setSeed(10);

			kmeans.setPreserveInstancesOrder(true);
			kmeans.setNumClusters(numClusters);

			weka.core.converters.ConverterUtils.DataSource source = new weka.core.converters.ConverterUtils.DataSource(new PropertyUtils().getProperty("datafiles-home")+"\\links.arff");
			Instances instances = source.getDataSet();

			//inst.setDataset(instances);
			kmeans.buildClusterer(instances);
			System.out.println(kmeans.displayStdDevsTipText());
			
			// This array returns the cluster number (starting with 0) for each instance
			// The array has as many elements as the number of instances
			int[] assignments = kmeans.getAssignments();

			int i=0;
			
			List<Cluster> lc = new ArrayList<Cluster>();
			for(int clusterNum : assignments) {
				lc.add(new Cluster((i+1) , clusterNum));
			  //  System.out.println("Instance "+(i+1)+" -> Cluster "+clusterNum);
			    i++;
			    
			}
			Collections.sort(lc);
			
			for(Cluster c : lc){
				PrintUtils.println("Instance : "+c.getInstance()+" Cluster "+c.getCluster());
			}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public static void main(String args[]){
		
		
	}

}
