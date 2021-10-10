#!/bin/sh
exec scala -deprecation "$0" "$@"
!#

import scala.io.StdIn.readLine
import scala.collection.immutable.SortedMap
import scala.collection.mutable.ListBuffer







object Main extends App {

 print("Please enter Temp (hot or cold) followed by selected numbers: ")
    val cmd:List[String]= readLine().split("[\\s,]+" ).toList
    val temp:String = cmd.head.toLowerCase()
    //if indexs were ints then map conversion is need but if map indexes were strings unneccessary
    val values:List[Int] = cmd.tail.map(_.toInt)
   
    

   season(temp, values)
    
   


def season(temp:String, values:List[Int]):Unit={
     val listBufferIntialize:ListBuffer[String] = ListBuffer()

   if(values(0) == 8){
   temp match{
     case "hot"  => getReturn(temp,values, hot(), listBufferIntialize)
     case "cold" => getReturn(temp, values, Main.cold(), listBufferIntialize)
     case _ => List("Was not hot or cold")
}
   }
  else{
    println("fail")

  }

}








  
def hot():Map[Int, (String,String)] = Map(
                1 -> ("Put on footwear", "sandals"),
                2 -> ("Put on headwear", "sunglasses"),
                3 -> ("Put on socks", "fail"),
                4 -> ( "Put on shirt", "shirt"),
                5 -> ( "Put on jacket", "fail"),
                6 -> ("Put on pants", "shorts"),
                7 -> ("Leave house", "leaving house"),
                8 -> ("Take off pajamas", "Removing PJs" )

).withDefaultValue(("fail", "fail"))

def cold(): Map[Int, (String,String)]= Map(
             1 -> ("Put on footwear", "boots"),
             2 -> ("Put on headwear", "hat"),
             3 -> ("Put on socks", "socks"),
             4->("Put on shirt", "shirt" ),
             5-> ("Put on jacket", "jacket"),
             6-> ("Put on pants", "pants"),
             7 -> ("Leave house", "leaving house"),
             8-> ("Take off pajamas", "Removing PJs")
).withDefaultValue(("fail", "fail")) 


def getReturn(temp:String, values: List[Int], wear: Map[Int,(String, String)], result: ListBuffer[String] ):String = {
    val fail:String = List("fail").mkString(",")
    val finalResult:String =result.toList.mkString(",")

   values match {
       
   case Nil =>  
                  if(temp == "hot" && wear.size ==2 || temp =="cold" && wear.size == 0){
                     
                  println(finalResult) 
                  finalResult
                  }
                  else{
                    result += "incomplete"
                    
                     print(finalResult)
                     finalResult
                  }

                 

 
// * Socks must be put on before footwear - [3,1]
// *  Pants must be put on before footwear - [6,1]



  
//  case value::_  if(value == 1 &&  wear(3) != ("fail", "fail")) || 
//                    (value == 6) && wear(1) != ("fail", "fail") =>  
//                  
//                    var getValue:(String,String) = wear(value)
//                                         result += getValue._2
 //                       getReturn(temp, Nil, wear, result += "fail")
   
  //*   The shirt must be put on before the headwear or jacket -[5,4,2]
  case value::_   if(value  == 2  && wear(4) != ("fail", "fail")  ||
                     wear(value)._2 == "jacket" &&  wear(4) != ("fail", "fail")
 )=>
                       
                        var getValue:(String,String) = wear(value)
                        result += getValue._2
                        getReturn(temp,Nil, wear, result += "fail")
  
  
  
   case value::rest => var getValue:(String,String) = wear(value)
                                              
                    
                      var remove = wear - value
                      
                      if(getValue._2 != "fail"){ 
                      getReturn(temp, rest, remove,   result += getValue._2)
                      }
                       else {
                       getReturn(temp, Nil, wear, result += getValue._2)  
                       }

 
 //case value if (value(0) != 8) => print(fail)
   //                               fail



   }
       
   


  }



   


}















