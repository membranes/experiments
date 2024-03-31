package pattern.intelligence

import org.apache.spark.sql.SparkSession
import functions.FetchDataURL
import environment.{EnvironmentDirectories, EnvironmentPaths}

import java.nio.file.Paths

class Executions(spark: SparkSession) {

  private val environmentPaths = new EnvironmentPaths()
  val environmentDirectories = new EnvironmentDirectories()

  def executions(): Unit = {



    val fetchDataURL = new FetchDataURL()
    fetchDataURL.fetchDataURL(urlString = "",
      pathString = Paths.get(environmentPaths.dataDirectory, "").toString)

  }

}
