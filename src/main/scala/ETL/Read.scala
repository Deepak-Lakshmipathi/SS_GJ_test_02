package ETL


import org.apache.spark.sql.SparkSession

class Read {
  //val s3_path:String = "s3://s3-test-550-2019/craigslistcarsFull.csv"
  val spark_ = SparkSession.builder().appName("Test_app").master("local").getOrCreate()
  val x  = spark_.read.option("inferSchema", "true").option("header","true").csv("s3://s3-test-550-2019/craigslistcars.csv")
  //println(x.show(2))

}
