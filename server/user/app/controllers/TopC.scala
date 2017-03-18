package controllers

import javax.inject._

import daos.UserDAOImpl
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by yukihirai on 2017/03/18.
  */
@Singleton
class TopC @Inject()(dbConfigProvider: DatabaseConfigProvider) extends Controller {

  def index = Action.async {
    new UserDAOImpl(dbConfigProvider).listAll.flatMap { user =>
      user.foreach(println)
      Future successful Ok(views.html.index("Your new application is ready."))
    }
  }

}
