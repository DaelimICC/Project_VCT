package com.daelimicc.server.vct.mg.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
@EnableScheduling
public class WebSocketHandler extends TextWebSocketHandler {
    // NOT USED
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info(message.getPayload());
    }

    // Chart Socket (Period 1sec)
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("Connected"));
        try {
            TimerTask task = new TimerTask() {
                public void run() {
                    try {
                        session.sendMessage(new TextMessage("Temp Message"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            Timer timer = new Timer("ChartThreadTimer");
            long delay = 3000L;
            long period = 1000L;
            timer.schedule(task, delay, period);
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }
}
