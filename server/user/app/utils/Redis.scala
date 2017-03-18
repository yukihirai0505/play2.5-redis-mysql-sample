package utils

import akka.actor.ActorSystem
import com.redis.{RedisClient, RedisClientSettings}
import akka.util.Timeout
import com.redis.RedisClientSettings.{ConstantReconnectionSettings, ReconnectionSettings}

import scala.concurrent.Future
import scala.concurrent.duration._

/**
  * Created by yukihirai on 2017/03/18.
  */
object Redis extends Redis {
}
trait Redis extends Config {
  implicit val implicitRedisClient = ActorSystem("redis-client-actor")
  implicit val implicitTimeout = Timeout(5.second)
  private val reconnect: ReconnectionSettings = ConstantReconnectionSettings(constantDelayMs = 5000, maximumAttempts = 17280)
  val client = RedisClient(redisConfig.host, redisConfig.port, "redis-client", RedisClientSettings(reconnectionSettings = reconnect))

  def setRedisString(key: String, expire: Int, value: String): Future[Boolean] = client.setex(key, expire, value)
  def getRedisString(key: String): Future[Option[String]] = client.get(key)
  def delRedis(key: String): Future[Long] = client.del(key)
  def setRedis(key: String, value: String): Future[Boolean] = client.set(key, value)
  def getRedis(key: String):Future[Option[String]] = client.get(key)
}