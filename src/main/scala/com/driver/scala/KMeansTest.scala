package com.driver.scala

import nak.cluster.Point
import nak.cluster.Kmeans

object KMeansTest {
  
  
  import nak.cluster.Kmeans
  import breeze.linalg.DenseVector
  import breeze.numerics._

 def main(args: Array[String]) {

    val p1 = new Point(IndexedSeq(0,0,0));
    val p2 = new Point(IndexedSeq(0,0,1));
    val p3 = new Point(IndexedSeq(0,1,1));
    val p4 = new Point(IndexedSeq(1,1,1));
    val p5 = new Point(IndexedSeq(0,1,1));
    val p6 = new Point(IndexedSeq(1,0,0));
    val p7 = new Point(IndexedSeq(1,0,1));
    val p8 = new Point(IndexedSeq(0,1,0));
   
    
    val clusters =  IndexedSeq( p1 , p2 , p3, p4, p5, p6, p7, p8 )
    
    
    val k = new Kmeans(clusters , nak.cluster.ManhattanDistance)
   
    val (dispersion, centroids) = k.run(3, 1);
    k.computeClusterMemberships(centroids)
    
    
 }
}