package pattern.intelligence
package s3

import scala.util.control.Exception
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.{CreateBucketRequest, CreateBucketResponse, HeadBucketRequest, HeadBucketResponse}

import scala.util.Try

/**
 *
 * @param s3Client: The Amazon S3 Client authentication object
 */
class Bucket(s3Client: S3Client) {

  /**
   *
   * @param bucketName: The name of a Amazon S3 bucket of interest
   */
  def createBucket(bucketName: String): Unit = {

    if (isBucket(bucketName = bucketName)) {

      println("The bucket %s exists.", bucketName)

    } else {

      val bucketRequest: CreateBucketRequest = CreateBucketRequest.builder()
        .bucket(bucketName).build()

      val exc: Try[CreateBucketResponse] = Exception.allCatch.withTry(
        s3Client.createBucket(bucketRequest))

      if (exc.isFailure) {
        sys.error(exc.failed.get.getMessage)
      } else {
        println("The bucket %s has been created.", bucketName)
      }

    }

  }

  /**
   *
   * @param bucketName: The name of a Amazon S3 bucket of interest
   * @return
   */
  private def isBucket(bucketName: String): Boolean = {

    val headBucketRequest = HeadBucketRequest.builder().bucket(bucketName).build()
    val exc: Try[HeadBucketResponse] = Exception.allCatch.withTry(
      s3Client.headBucket(headBucketRequest)
    )
    exc.isSuccess

  }





}
