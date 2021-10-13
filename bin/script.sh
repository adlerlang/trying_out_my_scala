#!/bin/sh
exec scala -deprecation "$0" "$@"
!#

import scala.io.StdIn.readLine
import scala.collection.immutable.SortedMap
import scala.collection.mutable.ListBuffer







object Main extends App {

 print("Please enter Temp (hot or cold) followed by selected numbers: ")
    val cmd:List[String]= readLine().split("[\\s,]+" ).toList
    val temp:String = cmd.head.trim.toLowerCase()
    //if indexs were ints then map conversion is need but if map indexes were strings unneccessary
    try{
    val values:List[Int] = cmd.tail.map(_.toInt)
  
  
    }
    catch{
      case _:Throwable => println("nothing entered or is not integer somewhere")
    }
    

    
   we

