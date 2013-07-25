package data

import scala.PartialFunction.cond

class Similarity {
  
  def getJaccardCoefficient(number1 : IndexedSeq[Int] , number2 : IndexedSeq[Int]) = {
    
    val p : Double =   number1.intersect(number2).size
    val q : Double = number1.zip(number2).filter(x => x._1==1 && x._2==0).size  
    val r : Double = number1.zip(number2).filter(x => x._1==0 && x._2==1).size
    val s = number1.zip(number2).filter(x => x._1==0 && x._2==0).size
    
    
    val coeff = p / (p + q + r)
    println("P "+p);
    println("Q "+q);
    println("R "+r);
    println("S "+s);
    println("Jaccard Coefficient "+coeff);
    
    coeff
    
  }
    
}

