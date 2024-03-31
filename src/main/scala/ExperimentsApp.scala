package pattern.intelligence

import environment.{EnvironmentDirectories, EnvironmentPaths}

import org.apache.logging.log4j.{Level, LogManager}
import org.apache.spark.sql.SparkSession



object ExperimentsApp {

  private val environmentPaths = new EnvironmentPaths()
  private val environmentDirectories = new EnvironmentDirectories()

  def main(args: Array[String]): Unit = {

    // Switching off logs
    val logger = LogManager.getLogger()
    logger.log(Level.forName("org", 0), "for: org")
    logger.log(Level.forName("aka", 0), "for: aka")

    // Spark Session
    val spark: SparkSession = SparkSession.builder()
      .appName("ExperimentsApp")
      .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .config("spark.sql.warehouse.dir", "")
      .getOrCreate()

    // Spark Logs
    spark.sparkContext.setLogLevel("ERROR")

    // Configuring
    val threads: Int = scala.math.ceil(java.lang.Runtime.getRuntime.availableProcessors()).toInt
    val limit: Int = math.floor(threads / 2).toInt
    spark.conf.set("spark.sql.shuffle.partitions", limit.toString)
    spark.conf.set("spark.default.parallelism", limit.toString)

    // Directories
    List(environmentPaths.coded, environmentPaths.decoded).foreach { pathString: String =>
      environmentDirectories.reset(directoryName = pathString)
    }

    // Computations
    val executing = new Executing(spark = spark)
    executing.executing()

  }

}
