import scala.collection.immutable.SortedMap
import scala.collection.mutable.ListBuffer







object Main extends App {

def main(args: Array[Any]): Unit = {
  val arrayToList:List[Any] =args.toList
val temp:String= arrayToList.head.toString()
val values: List[Any] = arrayToList.tail
season(temp,values)

}



def season(temp:String, values:List[Any]){
   temp match{
     case "Hot" => hot()
     case "Cold" => cold()
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


def getReturn(values: List[Int], wear: Map[Int,(String, String)], result: ListBuffer[String] ):List[String] = {
   


   values match {
   case Nil => result.toList
 
   // * Socks must be put on before footwear - [3,1]
  // *  Pants must be put on before footwear - [6,1]
  //*   The shirt must be put on before the headwear or jacket -[4,2]
  
  case value::_  if(value == 1 &&  wear(3) != ("fail", "fail")) || 
                    (value == 6) && wear(1) != ("fail", "fail") =>  
                    var getValue:(String,String) = wear(value)
                                         result += getValue._2
                        getReturn(Nil, wear, result += "fail")
   
  case value::_   if(value  == 2 || wear(value)._2 == "jacket" && wear(4) != ("fail", "fail") )=>
                        var getValue:(String,String) = wear(value)
                        result += getValue._2
                        getReturn(Nil, wear, result += "fail")
  
  
  
   case value::rest => var getValue:(String,String) = wear(value)
                                              
                    
                      var remove = wear - value
                      
                      if(getValue._2 != "fail"){ 
                      getReturn(rest, remove,   result += getValue._2)
                      }
                       else {
                       getReturn(Nil, wear, result += getValue._2)  
                       }

 
 case value if (value(0) != 8) => getReturn(Nil, wear , result += "fail") 
 
     return result.toList


   }
       
   


  }



   


}















