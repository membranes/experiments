package pattern.intelligence
package environment

import org.apache.commons.io.FileUtils

import java.io.File
import scala.util.Try
import scala.util.control.Exception


/**
 * '''About'''
 * For setting up directories
 *
 */
class EnvironmentDirectories {

  /**
   *
   * @param directoryName: A directory name string
   */
  def reset(directoryName: String): Unit = {

    val deleteDirectory = delete(directoryName = directoryName)

    if (deleteDirectory.isSuccess) {
      create(directoryName = directoryName)
    } else {
      sys.error(deleteDirectory.failed.get.getMessage)
    }

  }

  /**
   *
   * @param directoryName: A directory name string
   * @return
   */
  def create(directoryName: String): Try[Boolean] = {



    // Object
    val directoryObject = new File(directoryName)

    val create: Try[Boolean] = Exception.allCatch.withTry(
      if (!directoryObject.exists()) {
        directoryObject.mkdirs()
      } else {
        true
      }
    )

    if (create.isFailure) {
      sys.error(create.failed.get.getMessage)
    } else {
      create
    }

  }

  /**
   *
   * @param directoryName: A directory name string
   * @return
   */
  def delete(directoryName: String): Try[Boolean] = {

    // Object
    val directoryObject = new File(directoryName)

    Exception.allCatch.withTry(
      if (directoryObject.exists()) {
        Exception.allCatch.withTry(
          FileUtils.deleteDirectory(directoryObject)).isSuccess
      } else {
        true
      }
    )

  }

}
