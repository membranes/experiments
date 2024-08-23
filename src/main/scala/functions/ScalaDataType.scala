package pattern.intelligence
package functions

import org.apache.spark.sql.types.*

class ScalaDataType {

  def scalaDataType(dataTypeOfVariable: DataType): Unit = {

    dataTypeOfVariable match {
      case _: ByteType => Byte
      case _: ShortType => Short
      case _: IntegerType => Int
      case _: LongType => Long
      case _: FloatType => Float
      case _: DoubleType => Double
      case _: DecimalType => scala.math.BigDecimal
      case _: BinaryType => Byte
      case _: BooleanType => Boolean
      case _: TimestampType => TimestampType // Beware
      case _: DateType => DateType
      case _: ArrayType => scala.collection.Seq
      case _: StructType => org.apache.spark.sql.Row
      case _: MapType => scala.collection.Map
      case _: StringType => StringType
      case _ => StringType
    }

  }

}
