package lu.lnds.daam

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import java.time.Duration

class GetSimulation : Simulation() {

    val httpProtocol = http
        .baseUrl("http://localhost:8080")
        .acceptHeader("application/json")

    val scn = scenario("lu.lnds.daam.GetSimulation")
        .forever()
        .on(exec(http("GET").get("/api/v1/applications")
            .header("Content-Type", "application/json")))

    init {
        this.setUp(scn.injectOpen(rampUsers(100).during(Duration.ofSeconds(10))))
            .protocols(httpProtocol)
            .maxDuration(Duration.ofMinutes(1))
    }
}