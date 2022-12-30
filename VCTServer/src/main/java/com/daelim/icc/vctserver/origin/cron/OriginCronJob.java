package com.daelim.icc.vctserver.origin.cron;

import com.daelim.icc.vctserver.origin.response.VegetableList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.yaml.snakeyaml.util.UriEncoder;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
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

    private RestTemplate restTemplate;
    private MultiValueMap<String, String> params;

    @PostConstruct
    private void init(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        factory.setHttpClient(client);

        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(factory);

        params = new LinkedMultiValueMap<>();

        params.add("id", api_id);
        params.add("passwd", api_pwd);
        params.add("dataid", api_data);
        params.add("pagesize","10");
        params.add("pageidx", "1");
        params.add("portal.templet", "false");
        params.add("p_ymd", "20221117");
        params.add("p_jymd", "20221116");
        params.add("p_jjymd", "20211116");
        params.add("d_cd", api_div);
        params.add("p_pos_gubun", api_pos);
    }


    @GetMapping("")
    public String updatePrice() throws JAXBException {
        params.add("pum_nm", "사과");

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(api_url).queryParams(params)
                .build();

        ResponseEntity<String> response = restTemplate.getForEntity(uri.toUri(), String.class);

        JAXBContext jaxbContext = JAXBContext.newInstance(VegetableList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        VegetableList list = (VegetableList)unmarshaller.unmarshal(new StringReader(response.getBody()));
        return list.toString();
    }
}
