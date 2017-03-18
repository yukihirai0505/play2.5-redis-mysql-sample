package utils

import com.typesafe.config.ConfigFactory
import utils.Config.RedisConfig

/**
  * Created by yukihirai on 2017/03/18.
  */
object Config extends Config {
  sealed case class RedisConfig(host: String, port: Int)
}
trait Config {
  private val config = ConfigFactory.load()
  private val redis = config.getConfig("redis")
  val redisConfig = RedisConfig(
    host = redis.getString("host")
    , port = redis.getInt("port")
  )
}