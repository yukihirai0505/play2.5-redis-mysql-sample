package utils

import javax.inject.Inject

import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.Controller
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

/**
  * Created by yukihirai on 2017/03/18.
  */
class BaseC @Inject()(dbConfigProvider: DatabaseConfigProvider) extends Controller {

  val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  val db: JdbcBackend#DatabaseDef = dbConfig.db

}
