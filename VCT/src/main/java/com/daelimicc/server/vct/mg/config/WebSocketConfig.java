package com.daelimicc.server.vct.mg.config;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //registry.addHandler(new WebSocketHandler(), "/ws").setAllowedOrigins("*");
    }
}
