package com.daelim.icc.vctserver;

import com.daelim.icc.vctserver.origin.cron.OriginCronJob;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OriginTest extends BasicTestClass {
    @Autowired
    private OriginCronJob cronJob;

    @Test
    @Order(1)
    public void origin() throws Exception {
        cronJob.cronUpdateOriginDate();
    }
}
