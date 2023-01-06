package com.daelim.icc.vctserver.constdata;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateFormatter {
    private SimpleDateFormat format;

    @PostConstruct
    private void init(){
        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    public String format(Date date){
        return format.format(date);
    }
}
