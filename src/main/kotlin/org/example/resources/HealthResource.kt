package org.example.resources

import org.example.model.response.HealthResponse
import java.time.Instant
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("api/healthcheck")
@Produces(APPLICATION_JSON)
class HealthResource {

    @GET
    fun checkApiHealth(): HealthResponse {
        val healthResponse = HealthResponse()
        healthResponse.name = "github-api"
        healthResponse.version = "1.0"
        val timestamp = Instant.now().toEpochMilli()
        healthResponse.time = timestamp
        return healthResponse
    }

}