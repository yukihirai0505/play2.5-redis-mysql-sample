package utils

import org.scalatestplus.play._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class RedisSpec extends PlaySpec with OneAppPerTest {

  "Redis" should {

    "set redis and get value " in  {
      val key = "hoge"
      val value = "fuga"
      Redis.setRedis(key, value)
      val result = Redis.getRedis(key)
      Redis.delRedis(key)
      Await.result(result, Duration.Inf) mustBe Some(value)
    }

  }

}
