package com.daelim.icc.vctserver;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class OriginTest extends BasicTestClass{
    @Test
    public void origin() throws Exception {
        mockMvc.perform(get("/origin"));
    }
}
