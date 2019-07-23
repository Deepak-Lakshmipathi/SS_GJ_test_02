package ETL


object ETL_O {
  def main(args: Array[String]): Unit = {
    val dat = new ETL.Read
    val temp = dat.x.select("manufacturer","make","city").na.drop(how = "any")

    val temp_city = temp.groupBy("city").count()
    val temp_make = temp.groupBy("make").count()
    val temp_mani = temp.groupBy("manufacturer").count()

    println(temp_city.show())
    println(temp_make.show())
    println(temp_mani.show())

    temp.write.option("header","true").csv("s3://s3-test-550-2019/test")
    val I  = dat.spark_.read.option("inferSchema", "true").option("header","true").csv("s3://s3-test-550-2019/test")
    I.show(30)

  }


}
