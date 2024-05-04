package pattern.intelligence
package s3

import software.amazon.awssdk.http.apache.ApacheHttpClient
import software.amazon.awssdk.services.s3.S3Client

class Authentication {

  def authentication(): S3Client = {

    // Re-visit the region specification
    val s3Client: S3Client = S3Client.builder()
      .httpClientBuilder(ApacheHttpClient.builder())
      .build()

    s3Client

  }

}
