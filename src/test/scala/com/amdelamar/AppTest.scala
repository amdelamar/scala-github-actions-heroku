package com.amdelamar

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

class AppTest extends FlatSpec
  with Matchers
  with ScalatestRouteTest {

  val routes = App.routeApi

  "GET /" should "return 200" in {
    Get("/") ~> routes ~> check {
      status.intValue() shouldBe 200
    }
  }

  "PUT /" should "return 200" in {
    Put("/") ~> routes ~> check {
      status.intValue() shouldBe 200
    }
  }

}
