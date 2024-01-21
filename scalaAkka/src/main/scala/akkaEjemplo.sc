

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpEntity, HttpMethods, HttpRequest, HttpResponse}
import akka.stream.ActorMaterializer
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

object akkaEjemplo extends App{

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "https://keepcoding.io/blog/que-es-scala-y-donde-se-usa/"
  )

  def sendRequest() = {
    val responseFuture: Future[HttpResponse] = Http().singleRequest(request)
    val entityFuture: Future[HttpEntity.Strict] = responseFuture.flatMap(_.entity.toStrict(5.seconds))
    entityFuture.map(_.data.utf8String)
  }

  sendRequest().map(x =>
    println(x)
  ).recover(
    a => println("Something went wrong")
  )
}
