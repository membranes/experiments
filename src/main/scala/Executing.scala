package pattern.intelligence

import org.apache.spark.sql.SparkSession
import functions.FetchDataURL
import environment.{EnvironmentDirectories, EnvironmentPaths}

import java.nio.file.Paths

class Executing(spark: SparkSession) {

  private val environmentPaths = new EnvironmentPaths()
  private val environmentDirectories = new EnvironmentDirectories()

  def executions(): Unit = {

    val urlString = "https://download.companieshouse.gov.uk/BasicCompanyData-2024-03-01-part1_7.zip"
    val name = urlString.split("/").last.trim

    val fetchDataURL = new FetchDataURL()
    fetchDataURL.fetchDataURL(urlString = urlString,
      pathString = Paths.get(environmentPaths.coded, name).toString)

  }

}
