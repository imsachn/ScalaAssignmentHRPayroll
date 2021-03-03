package com.hashedin.service

trait SalaryHikeService {

  def salaryHikeDetails(fileName: String): Unit
  def salaryCalculations(salary: Double): Unit
  def hikeCalculations(currentSalary: Int, totalExp: Double, hashedinExp: Double, promotion: Boolean): Double

}




