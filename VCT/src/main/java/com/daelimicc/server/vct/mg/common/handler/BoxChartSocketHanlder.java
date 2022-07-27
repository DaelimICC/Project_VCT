package com.daelimicc.server.vct.mg.common.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class BoxChartSocketHanlder extends TextWebSocketHandler {
    @Override
    public synchronized void afterConnectionEstablished(WebSocketSession session) throws Exception {
        try {
            TimerTask task = new TimerTask() {
                public void run() {
                    try {
                        session.sendMessage(new TextMessage("Test"));
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
