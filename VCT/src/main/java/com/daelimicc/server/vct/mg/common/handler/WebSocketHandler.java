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

        final String dummyData = "[\n" +
                "    {\n" +
                "        \"high\" : \"20860\",\n" +
                "        \"open\" : \"20380\",\n" +
                "        \"close\" : \"20535\",\n" +
                "        \"low\" : \"19663\",\n" +
                "        \"volume\" : \"37\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"21468\",\n" +
                "        \"open\" : \"20535\",\n" +
                "        \"close\" : \"21462\",\n" +
                "        \"low\" : \"19663\",\n" +
                "        \"volume\" : \"21\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"21677\",\n" +
                "        \"open\" : \"21462\",\n" +
                "        \"close\" : \"19924\",\n" +
                "        \"low\" : \"19619\",\n" +
                "        \"volume\" : \"-13\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"21677\",\n" +
                "        \"open\" : \"19924\",\n" +
                "        \"close\" : \"20330\",\n" +
                "        \"low\" : \"18879\",\n" +
                "        \"volume\" : \"3\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"21820\",\n" +
                "        \"open\" : \"20330\",\n" +
                "        \"close\" : \"21850\",\n" +
                "        \"low\" : \"18879\",\n" +
                "        \"volume\" : \"70\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"22163\",\n" +
                "        \"open\" : \"21805\",\n" +
                "        \"close\" : \"19889\",\n" +
                "        \"low\" : \"18970\",\n" +
                "        \"volume\" : \"-102\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"22163\",\n" +
                "        \"open\" : \"19889\",\n" +
                "        \"close\" : \"20243\",\n" +
                "        \"low\" : \"18879\",\n" +
                "        \"volume\" : \"10\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"22163\",\n" +
                "        \"open\" : \"20243\",\n" +
                "        \"close\" : \"20855\",\n" +
                "        \"low\" : \"18879\",\n" +
                "        \"volume\" : \"3\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"22456\",\n" +
                "        \"open\" : \"20855\",\n" +
                "        \"close\" : \"21601\",\n" +
                "        \"low\" : \"18879\",\n" +
                "        \"volume\" : \"11\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"high\" : \"22494\",\n" +
                "        \"open\" : \"21601\",\n" +
                "        \"close\" : \"22494\",\n" +
                "        \"low\" : \"18879\",\n" +
                "        \"volume\" : \"33\"\n" +
                "    }\n" +
                "\n" +
                "]";

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
                    session.sendMessage(new TextMessage(dummyData));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (IllegalStateException ignored) {
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
