import slick.codegen.SourceCodeGenerator
import slick.{model => m}

/**
  *  1. http://slick.typesafe.com/doc/3.1.0/code-generation.html
  *
  *  2. http://stackoverflow.com/questions/22275022/customizing-slick-generator
  *
  *
  */
class CustomGenerator(model: m.Model) extends SourceCodeGenerator(model) {

  // add some custom imports
  override def code = "import com.github.tototoshi.slick.MySQLJodaSupport._\n" + "import org.joda.time.DateTime\n" + super.code
  override def Table = new Table(_) {
    override def autoIncLastAsOption = true
    override def Column = new Column(_) {
      override def rawType = model.tpe match {
        case "java.sql.Timestamp" => "DateTime"
        case "java.sql.Date" => "DateTime"
        case _ => super.rawType
      }
    }
  }
}
