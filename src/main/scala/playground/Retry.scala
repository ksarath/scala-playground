package playground

import cats.effect._
import cats.syntax.apply._

import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Retry {
  implicit val timer = IO.timer(global)

  def retryWithDelay[T](fn: => T, delay: FiniteDuration, maxRetries: Int = 0): IO[T] = IO.suspend {
    Try(fn) match {
      case Failure(exception) if maxRetries > 0 =>
        IO.sleep(delay) *> retryWithDelay(fn, delay, maxRetries - 1)

      case Failure(exception) => IO.raiseError(exception)

      case Success(value) => IO.pure(value)

    }
  }
}
