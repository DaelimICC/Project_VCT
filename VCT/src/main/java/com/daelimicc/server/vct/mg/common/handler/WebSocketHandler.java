package com.daelimicc.server.vct.mg.common.handler;

import com.daelimicc.server.vct.coin.domain.Coin;
import com.daelimicc.server.vct.coin.repository.CoinRepository;
import com.daelimicc.server.vct.status.repository.CoinStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.OnClose;
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
    private final CoinStatusRepository coinStatusRepository;

    public List<Coin> getCoinChartList() {
        return coinRepository.findAll();
    }

    // Chart Socket (Period 1sec)
    @Override
    public synchronized void afterConnectionEstablished(WebSocketSession session) throws IOException {

        Timer timer = new Timer("ChartThreadTimer");
        long delay = 3000L;
        long period = 1000L;
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if(!session.isOpen()) {
                        log.info("Session is closed");
                        this.cancel();
                    }
                    session.sendMessage(new TextMessage(getCoinChartList().toString()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (IllegalStateException e) {
                    throw new IllegalStateException(e);
                }
            }
        };

        timer.schedule(task, delay, period);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        log.info("WebSocket Close");
    }
}
