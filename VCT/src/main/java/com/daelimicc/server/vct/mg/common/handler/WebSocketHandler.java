package com.daelimicc.server.vct.mg.common.handler;

import com.daelimicc.server.vct.coin.domain.Coin;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final CoinRepository coinRepository;

    public List<Coin> getCoinChartList() {
        return coinRepository.findAll();
    }

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
                        session.sendMessage(new TextMessage(getCoinChartList().toString()));
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
