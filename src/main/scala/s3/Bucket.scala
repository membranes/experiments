package pattern.intelligence
package s3

import scala.util.control.Exception
import com.amazonaws.services.s3.{AmazonS3, model}

import scala.util.Try

/**
 *
 * @param s3Client: The Amazon S3 Client authentication object
 */
class Bucket(s3Client: AmazonS3) {

  /**
   *
   * @param bucketName: The name of the Amazon S3 bucket of interest
   */
  def createBucket(bucketName: String): Unit = {

    if (s3Client.doesBucketExistV2(bucketName)) {
      println("The bucket %s exists.", bucketName)
    } else {

      val isExecuted: Try[model.Bucket] = Exception.allCatch.withTry(s3Client.createBucket(bucketName))
      if (isExecuted.isFailure) {
        sys.error(isExecuted.failed.get.getMessage)
      }

    }

  }

}
