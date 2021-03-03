package com.hashedin.service

import com.hashedin.Beans.SalaryInfo
import com.hashedin.Utils.Reader
import scala.collection.mutable.ListBuffer

class SalaryHikeServiceImpl extends SalaryHikeService{
  private val basicSalary=40:Double
  private val hra=20:Double
  private val lta=8:Double
  private val phoneAndInternet=7:Double
  private val others=25:Double
  private var salaryHikeDetail: ListBuffer[SalaryInfo] = _

  override def salaryCalculations(salary: Double): Unit ={
    println("total: " + salary)
    println("basic_salary: " + salary * (basicSalary/100))
    println("HRA: " + salary * (hra/100))
    println("LTA: " + salary * (lta/100))
    println("Phone_and_internet: " + salary*(phoneAndInternet/100))
    println("other: " + salary * (others/100) +" }")
  }
  override def hikeCalculations(currentSalary: Int, totalExp: Double, hashedinExp: Double, promotion: Boolean): Double = {
    val totalExpFilter = salaryHikeDetail.filter(x => x.hashedinExp == totalExp)
    val hashedinExpFilter = salaryHikeDetail.filter(x => x.hashedinExp == hashedinExp)
    var hikeSalary = 0.0
    if (totalExpFilter.isEmpty||hashedinExpFilter.isEmpty) {
      print("No Hike for mentioned total Experience " )
    }
      else {
        if (promotion) {
          hikeSalary = currentSalary * (totalExpFilter.head.normalHike / 100 + hashedinExpFilter.head.hashedinExpBonus / 100 + totalExpFilter.head.promotionBonus / 100)
        } else {
          hikeSalary = currentSalary * (totalExpFilter.head.normalHike / 100 + hashedinExpFilter.head.hashedinExpBonus / 100)
        }
      }
    hikeSalary
  }
  override def salaryHikeDetails(fileName: String): Unit = {
    val reader= new Reader()
    salaryHikeDetail = reader.read(fileName)
  }
}