
import scala.io.StdIn.readLine
import scala.collection.immutable.SortedMap
import scala.collection.mutable.ListBuffer


object Main extends App {

 print("Please enter Temp (hot or cold) followed by selected numbers: ")
    val cmd:List[String]= readLine().split("[\\s,]+" ).toList
    val temp:String = cmd.head.toLowerCase()
    //if indexs were ints then map conversion is need but if map indexes were strings unneccessary
     
    try {
    val values:List[Int] = cmd.tail.map(_.toInt)
    season(temp, values)}
    catch{
    case  _:Exception => print("Wrong entry (choose hot/cold) or values are digits (1-8)")
    }
   


def season(temp:String, values:List[Int]):List[String]={
     val listBufferIntialize:ListBuffer[String] = ListBuffer()

   if(values(0) == 8 ){
   temp match{
     case "hot"  => getReturn(temp,values, hot(), listBufferIntialize)
     case "cold" => getReturn(temp, values, Main.cold(), listBufferIntialize)
     case _ => List("Was not hot or cold")
}
   }
  else{
    println("fail")
    val listFail:List[String] = List("fail")
        listFail
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


def getReturn(temp:String, values: List[Int], wear: Map[Int,(String, String)], result: ListBuffer[String] ):List[String] = {
   

    val finalResult:List[String] =result.toList

   values match {
       
   case Nil  =>  
                var wearMap = wear

                 if(temp == "hot"){
                  wearMap =  wearMap -- Set(3,5)
                  
                 }
 
                   print(wearMap)
                  if(wearMap.size == 0){
                
                  println(finalResult.mkString(",")) 
                  finalResult
                  }
                  else{
                  
                    result.update(result.length - 1, "fail")        
                     print(result.toList.mkString(","))
                     finalResult
                  }

                 

 
// * Socks must be put on before footwear 
// *  Pants must be put on before footwear  
case value::_  if(temp == "cold" && value == 1 &&  wear(3) != ("fail", "fail")) || 
                    value == 1 && wear(6) != ("fail", "fail") => { 
                    var getValue:(String,String) = wear(value)
                    result += getValue._2
                    getReturn(temp, Nil, wear, result += "fail")
                    }
// * The shirt must be put on before the headwear or jacket
  case value::_   if( value  == 2  && wear(4) != ("fail", "fail")  ||
                       temp == "cold" && wear(value)._2 == "jacket" &&  wear(4) != ("fail", "fail")
                        )=>{ 
                        var getValue:(String,String) = wear(value)
                        result += getValue._2
                        getReturn(temp,Nil, wear, result += "fail")
                        }
  
  
   // * remove unneccessary hot values
  

  
   case value::rest => 
     
          var getValue:(String,String) = wear(value)
                                              
                    
                    

                      var remove = wear - value
                      
  


                      if(getValue._2 != "fail"){ 
                      getReturn(temp, rest, remove,   result += getValue._2)
                      }
                       else {
                      

                       getReturn(temp, Nil, wear, result += getValue._2)  
                       }

 
    


   }
       
   


  }



   


}















