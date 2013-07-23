package com.hml.weka;

import java.util.Comparator;

public class Cluster implements Comparable{
	
	private int instance;
	private int cluster;
	
	public Cluster(int instance, int cluster){
		this.instance = instance;
		this.cluster = cluster;
	}

	@Override
	public int compareTo(Object o) {
		
		Cluster p2 = (Cluster)o;
		
		if (cluster == p2.cluster)
			return 0;
		else if (cluster > p2.cluster)
			return 1;
		else
			return -1;
	}


	public int getInstance() {
		return instance;
	}

	public int getCluster() {
		return cluster;
	}
	
}
