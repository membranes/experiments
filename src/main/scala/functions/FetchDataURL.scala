package pattern.intelligence
package functions

import org.apache.commons.io.FileUtils

import java.io.File
import java.net.URL
import scala.util.Try
import scala.util.control.Exception

/**
 *
 */
class FetchDataURL {

  /**
   *
   * @param urlString: The uniform resource locator of a data set
   * @param pathString: The {[temporary] local depository} + {name} + {extension} for the fetched data set.
   */
  def fetchDataURL(urlString: String, pathString: String): Boolean = {

    val fetch: Try[Unit] = Exception.allCatch.withTry(
      FileUtils.copyURLToFile(new URL(urlString), new File(pathString))
    )

    if (fetch.isFailure) {
      sys.error(fetch.failed.get.getMessage)
    } else {
      true
    }

  }

}
