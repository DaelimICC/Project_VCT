package com.daelim.icc.vctserver.origin.cron;

import com.daelim.icc.vctserver.origin.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController()
@RequestMapping("origin")
public class OriginCronJob {

    // Load Environment Value for Garak Market API
    @Value("${spring.outapi.id}")
    private String api_id;
    @Value("${spring.outapi.pwd}")
    private String api_pwd;
    @Value("${spring.outapi.pos}")
    private String api_pos;
    @Value("${spring.outapi.div}")
    private String api_div;
    @Value("${spring.outapi.url}")
    private String api_url;
    @Value("${spring.outapi.data}")
    private String api_data;



    @GetMapping("")
    public String updatePrice() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_XML);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(header);


        String uri = api_url + "?" + "dataid=" + api_data
                                   + "&pagesize=1&pageidx=1&portal.templet=false"
                                   + "&id=" + api_id + "&passwd=" + api_pwd
                                   + "&p_ymd=" + "20221117" // 검색 일자
                                   + "&p_jymd=" + "20221116" // 전일 일자
                                   + "&p_jjymd=" + "20211116"
                                   + "&d_cd=" + api_div
                                   + "&p_pos_gubun=" + api_pos
                                   + "&pum_nm=" + "백다다기오이"; // 검색 작물

        ResponseDTO response = restTemplate.getForObject(uri, ResponseDTO.class);

        return response.toString();
    }
}
