package com.daelimicc.server.vct.mg.config;

import com.daelimicc.server.vct.mg.common.handler.BoxChartSocketHanlder;
import com.daelimicc.server.vct.mg.common.handler.WebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;
    private final BoxChartSocketHanlder boxChartSocketHanlder;

    public WebSocketConfig(WebSocketHandler webSocketHandler, BoxChartSocketHanlder boxChartSocketHanlder) {
        this.webSocketHandler = webSocketHandler;
        this.boxChartSocketHanlder = boxChartSocketHanlder;
    }
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws").setAllowedOrigins("*");
        registry.addHandler(boxChartSocketHanlder, "/ws/box").setAllowedOrigins("*");
    }



}
