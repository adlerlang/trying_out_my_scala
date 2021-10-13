import Main._


import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine



class MainTest extends org.scalatest.funsuite.AnyFunSuite {

 print("Please enter Temp (hot or cold) followed by selected numbers: ")
    val cmd:List[String]= readLine().split("[\\s,]+" ).toList
    val temp:String = cmd.head.toLowerCase()
    //if indexs were ints then map conversion is need but if map indexes were strings unneccessary
     
    try {
    val values:List[Int] = cmd.tail.map(_.toInt)
    temptest(temp, values)
  }
    catch{
    case  _:Exception => print("Space or Wrong entry (choose hot/cold) and shouldl be followed by values are digits (1-8)")
    }



  def temptest(temp:String, testData:List[Int]):Unit ={
    val tester = Main.season(temp, testData)
 test("Is Cold completed"){
      assert(tester == List("Removing PJs","shorts","shirt","sunglasses","sandals","leaving house"))
 }

test("headwear before shirt"){
  assert(tester == List("Removing PJs", "sunglasses", "fail"))


}

 test("Removing PJs at start"){
   assert(tester == List("fail"))
 }

 test("Is there dups or any invalids"){
   
    assert(tester == List("Removing PJs", "fail") || tester ==List("Removing PJs","shirt", "sunglasses","fail" ) ) 

}

test("hot can't have socks or jacket"){

   assert(tester == List("Removing PJs", "shirt", "fail") || tester == List("Removing PJs", "shirt", "hat", "socks"))

}




  }

}
