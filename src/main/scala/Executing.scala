package pattern.intelligence

import environment.{EnvironmentPaths, Temporary}
import functions.FetchDataURL
import s3.{Authentication, Bucket}

import com.amazonaws.services.s3.AmazonS3
import org.apache.spark.sql.SparkSession

import java.nio.file.Paths


class Executing(spark: SparkSession) {

  private val environmentPaths = new EnvironmentPaths()
  private val temporary = new Temporary()

  def executing(): Unit = {

    // An illustration of data unloading
    val urlString = "https://download.companieshouse.gov.uk/BasicCompanyData-2024-03-01-part1_7.zip"
    val name = urlString.split("/").last.trim

    val fetchDataURL = new FetchDataURL()
    fetchDataURL.fetchDataURL(urlString = urlString,
      pathString = Paths.get(environmentPaths.coded, name).toString)

    // An illustration of Amazon S3 bucket creation
    val s3Client: AmazonS3 = new Authentication().authentication()
    new Bucket(s3Client = s3Client).createBucket(bucketName = temporary.internal)

  }

}
