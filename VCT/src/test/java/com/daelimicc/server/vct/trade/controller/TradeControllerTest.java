package com.daelimicc.server.vct.trade.controller;

import com.daelimicc.server.vct.trade.domain.TradeHistory;
import com.daelimicc.server.vct.trade.repository.TradeHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TradeControllerTest {
    @Autowired
    TradeHistoryRepository tradeHistoryRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getTest() throws Exception {
        String testing = "Clear!";

        mockMvc.perform(get("/trade"))
                .andExpect(status().isOk());
    }

}