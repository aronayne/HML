package com.hml.weka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import weka.core.converters.ConverterUtils.DataSource;

public class WekaKmeansDriver {

	private String linkFile;
	private String idFile;
	private int numClusters;
	private Instances instances;
	private SimpleKMeans kmeans = new SimpleKMeans();
	
	public WekaKmeansDriver(int numClusters){
		this.numClusters = numClusters;
		this.setupFiles();
		this.setupKmeans();
		this.runKMeans();
	}
	
	private void setupFiles(){
		linkFile =  new PropertyUtils().getProperty("datafiles-home")+"\\links.arff";
		idFile = new PropertyUtils().getProperty("datafiles-home")+"\\ids.csv";
	}
	
	private void setupKmeans(){
		
		try {
			

			// DistanceFunction df = new weka.core.ManhattanDistance();
			DistanceFunction df = new weka.core.EuclideanDistance();

			kmeans.setDistanceFunction(df);
			kmeans.setSeed(10);

			kmeans.setPreserveInstancesOrder(true);
			kmeans.setNumClusters(numClusters);

			DataSource source = new DataSource(linkFile);
			instances = source.getDataSet();

			// inst.setDataset(instances);
			kmeans.buildClusterer(instances);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void runKMeans(){
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(idFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			// This array returns the cluster number (starting with 0) for each instance
			// The array has as many elements as the number of instances
			int[] assignments = kmeans.getAssignments();		    
		    int i=1;
		    Instance instance;
			List<Cluster> lc = new ArrayList<Cluster>();
			for(int clusterNum : assignments) {
				String id = br.readLine();
				instance = instances.instance(i-1);
				lc.add(new Cluster(id , clusterNum , instance.toString()));
			    i++;			    
			}		
			Collections.sort(lc);
			
			for(Cluster c : lc){
				PrintUtils.println(c.toString());
			}
		    
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	
	}
	
	public static void main(String args[]){
		
		
	}

}
