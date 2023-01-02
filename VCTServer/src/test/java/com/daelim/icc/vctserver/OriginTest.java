package com.daelim.icc.vctserver;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OriginTest extends BasicTestClass{
    @Test
    public void origin() throws Exception {
        mockMvc.perform(get("/origin"))
                .andExpect(status().isOk());
    }
}
