package com.daelimicc.server.vct.mg.common.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeMethod {
    public static String getCurrentDateTimeBySting() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss"));
    }
}
