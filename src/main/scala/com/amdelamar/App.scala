package com.amdelamar

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{HttpApp, Route}

import scala.util.Try

object App extends HttpApp {

  override protected def routes: Route = routeApi

  val routeApi = pathEndOrSingleSlash {
    get {
      complete("It works!")
    } ~
      put {
        complete("This also works!")
      }
  }

  def main(args: Array[String]): Unit = {
    val HOST = sys.env.getOrElse("HOST", "localhost")
    val PORT = Try(sys.env("PORT").toInt).getOrElse(8080)

    App.startServer(HOST, PORT)
  }
}
