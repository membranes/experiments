package pattern.intelligence

import org.apache.logging.log4j.{Level, LogManager}
import org.apache.spark.sql.SparkSession

object ExperimentsApp {

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

    /* Configuring for computation
     *
     * java.lang.Runtime.getRuntime.availableProcessors() deduces the number of machine threads
     * spark.sql.shuffle.partitions: The number of shuffle partitions for joins & aggregation
     * spark.default.parallelism: The default number of partitions delivered after a transformation
     * spark.speculation: If true "performs speculative execution of tasks. This means if one or more tasks are
     *                             running slowly in a stage, they will be re-launched."
     */
    val threads: Int = scala.math.ceil(java.lang.Runtime.getRuntime.availableProcessors()).toInt
    println(threads)

  }

}
