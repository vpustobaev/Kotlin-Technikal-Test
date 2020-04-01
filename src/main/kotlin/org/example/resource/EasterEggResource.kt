package org.example.resource

import org.example.response.EasterEggResponse
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/api/timemachine/logs/mcfly")
@Produces(APPLICATION_JSON)
class EasterEggResource {

    @GET
    fun getEasterEgg(): List<EasterEggResponse> {

        val responseList = ArrayList<EasterEggResponse>(3)

        val response1 = EasterEggResponse()
        response1.name = "My mom is in love with me"
        response1.version = "1.0"
        response1.time = -446723100
        responseList.add(response1)

        val response2 = EasterEggResponse()
        response2.name = "I go to the future and my mom end up with the wrong guy"
        response2.version = "2.0"
        response2.time = 1445470140
        responseList.add(response2)

        val response3 = EasterEggResponse()
        response3.name = "I go to the past and you will not believe what happens next"
        response3.version = "3.0"
        response3.time = -Long.MAX_VALUE

        responseList.add(response3)
        return responseList
    }

}