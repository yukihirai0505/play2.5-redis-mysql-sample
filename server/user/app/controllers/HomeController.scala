package controllers

import javax.inject._

import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc._
import utils.BaseC
import models.Tables.profile.api._
import models.Tables.User

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(dbConfigProvider: DatabaseConfigProvider) extends BaseC(dbConfigProvider) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    val result = Await result (db.run(User.result), Duration.Inf)
    result.foreach(println)
    Ok(views.html.index("Your new application is ready."))
  }

}
