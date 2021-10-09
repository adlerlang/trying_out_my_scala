import Main._


import scala.collection.mutable.ListBuffer




class MainTest extends org.scalatest.funsuite.AnyFunSuite {
 test("is getReturn working"){
  val temp:List[Int] = List(8,6,4,3, 25)
  val wear = Main.hot()
  val listBuffer:ListBuffer[String] = ListBuffer()
  var m = Main.getReturn(temp,wear, listBuffer )

print(m)
 

 }


}
