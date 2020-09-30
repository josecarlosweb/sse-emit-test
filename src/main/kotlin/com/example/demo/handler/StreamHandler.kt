package com.example.demo.handler

import com.example.demo.data.getPeople
import org.springframework.http.MediaType
import org.springframework.http.codec.ServerSentEvent
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Component
class StreamHandler {

    fun streamData(request: ServerRequest): Mono<ServerResponse> {
        val flux = Flux.merge(getPeopleData(), getKeepAliveFlux())
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(flux)
    }

    private fun getPeopleData() =
            Flux.interval(Duration.ofSeconds(20)).map { ServerSentEvent.builder(getPeople()).build() }

    private fun getKeepAliveFlux() =
            Flux.interval(Duration.ofSeconds(10)).map { aLong -> ServerSentEvent.builder(aLong).comment("keep alive").build() }
}

