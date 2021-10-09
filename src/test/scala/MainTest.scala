import Main._


import scala.collection.mutable.ListBuffer




class MainTest extends org.scalatest.funsuite.AnyFunSuite {
 test("is getReturn working"){
  val temp:List[Int] = List(8,5,4,2, 5,1 ,3)
  val wear = Main.cold()
  val listBuffer:ListBuffer[String] = ListBuffer()
  var m = Main.getReturn(temp,wear, listBuffer )

print(m)
 

 }


}
