package pattern.intelligence
package environment

import java.nio.file.Paths

/**
 * '''About'''
 * The project's environment paths.
 *
 * @note
 * Intrinsic Separator: java.nio.file.FileSystems.getDefault.getSeparator
 */
class EnvironmentPaths {

  private val projectDirectory: String = System.getProperty("user.dir")
  val separator: String = java.nio.file.FileSystems.getDefault.getSeparator

  // Data Directory
  val dataDirectory: String = Paths.get(projectDirectory, "data").toString
  val coded: String = Paths.get(projectDirectory, "data", "coded").toString
  val decoded: String = Paths.get(projectDirectory, "data", "decoded").toString

  // Warehouse Directory
  val warehouseDirectory: String = Paths.get(projectDirectory, "warehouse").toString


}
