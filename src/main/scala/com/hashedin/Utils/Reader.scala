package com.hashedin.Utils

import com.hashedin.Beans.SalaryInfo

import java.io.FileNotFoundException
import scala.collection.mutable.ListBuffer
import scala.io.Source

class Reader {

  def read(fileName: String): ListBuffer[SalaryInfo] = {
    var hikeDetails = new ListBuffer[SalaryInfo]()
    try {
      val fileSource = Source.fromFile(fileName)
      for (line <- fileSource.getLines.drop(1)) {
        val row = line.split(",").map(_.trim)
        try {
          hikeDetails += SalaryInfo(row(0).toDouble, row(1).toDouble, row(2).toDouble, row(3).toDouble, row(4).toDouble)
        } catch {
          case e: NumberFormatException =>
            println(e)
          case f: Exception =>
            println(f)
        }
      }
      fileSource.close()
    } catch {
      case i: FileNotFoundException =>
        throw new FileNotFoundException()
    }
    hikeDetails
  }
}