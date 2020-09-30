package com.example.demo

import com.example.demo.handler.StreamHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class RoutingConfiguration {

    @Bean
    fun routes(streamHandler: StreamHandler) = router {
        GET("/streaming", streamHandler::streamData)
    }

}