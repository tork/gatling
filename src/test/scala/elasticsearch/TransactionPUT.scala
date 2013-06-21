package elasticsearch

import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import akka.util.duration._

import bootstrap._

class ElasticPUTBenchmark extends Simulation {

  val httpConf = httpConfig
    .baseURL("http://bigdata01.dev.bekk.no:9200")
    .acceptCharsetHeader("ISO-8859-1,utf-8;q=0.7,*;q=0.7")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("fr,fr")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:8.0.1) Gecko/20100101 Firefox/8.0.1")

  val scn = scenario("ElasticSearch PUT benchmarking")
    .repeat(1) {
      exec(
        http("req0")
          .get("/gatling/ratatata/ta0")
          .check(status.is(200)))
          .pause(0 milliseconds, 100 milliseconds)
    }
}







//package jmeter
//
//import com.excilys.ebi.gatling.core.Predef._
//import com.excilys.ebi.gatling.http.Predef._
//import com.excilys.ebi.gatling.http.Headers.Names._
//import bootstrap._
//
//class JMeterBenchmark extends Simulation {
//
//  val httpConf = httpConfig
//    .baseURL("http://localhost:8080/examples/servlets")
//    .acceptCharsetHeader("ISO-8859-1,utf-8;q=0.7,*;q=0.7")
//    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
//    .acceptEncodingHeader("gzip, deflate")
//    .acceptLanguageHeader("fr,fr")
//    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:8.0.1) Gecko/20100101 Firefox/8.0.1")
//
//  val scn = scenario("JMeter Benckmark with Gatling")
//    .repeat(30) {
//    exec(http("sessionExample1")
//      .get("/servlet/SessionExample")
//      .check(status.is(200)))
//      .pause(5)
//      .exec(http("sessionExample2Post")
//      .post("/servlet/SessionExample")
//      .param("dataname", "TOTO")
//      .param("datavalue", "TITI")
//      .header(CONTENT_TYPE, "application/x-www-form-urlencoded")
//      .check(status.is(200)))
//      .pause(5)
//      .exec(http("index")
//      .get("/index.html")
//      .check(status.is(200)))
//      .pause(5)
//      .exec(http("sessionExample3")
//      .get("/servlet/SessionExample")
//      .check(status.is(200)))
//      .pause(5) //
//  }
//
//  setUp(scn.users(1500).ramp(100).delay(7).protocolConfig(httpConf))
//}