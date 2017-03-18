package daos

import com.google.inject.ImplementedBy
import models.Tables.UserRow

import scala.concurrent.Future

/**
  * Created by yukihirai on 2017/03/18.
  */
@ImplementedBy(classOf[UserDAOImpl])
trait UserDAO {

  def add(user: UserRow): Future[String]

  def get(id: Long): Future[Option[UserRow]]

  def delete(id: Long): Future[Int]

  def listAll: Future[Seq[UserRow]]

}
