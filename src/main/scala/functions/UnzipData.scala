package pattern.intelligence
package functions

import java.io.FileInputStream
import java.util.zip.{ZipEntry, ZipInputStream}

class UnzipData {

  def unzipData(pathString: String): Unit = {

    val zipInputStream: ZipInputStream = new ZipInputStream(new FileInputStream(pathString))
    var zipEntry: ZipEntry = zipInputStream.getNextEntry





  }

}
