package com.daelim.icc.vctserver.origin.cron;

import com.daelim.icc.vctserver.constdata.CoinList;
import com.daelim.icc.vctserver.origin.response.Vegetable;
import com.daelim.icc.vctserver.origin.response.VegetableList;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
@RequiredArgsConstructor
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
    private Unmarshaller unmarshaller;

    private final CoinMaker coinMaker;

    @PostConstruct
    private void init() throws JAXBException {
        setRestTemplate();
        setParams();
        setUnmarshaller();
    }

    private void setRestTemplate(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        factory.setHttpClient(client);

        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(factory);
    }

    private void setParams(){
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

    private void setUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(VegetableList.class);
        unmarshaller = jaxbContext.createUnmarshaller();
    }

    @Scheduled(cron = "0 0 */12 * * *")
    public void cronUpdateOriginDate() throws JAXBException {
        for(CoinList coin : CoinList.values()) {
            initCoinData(coin);
        }
    }

    private void initCoinData(CoinList coinList) throws JAXBException {
        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl(api_url)
                .queryParams(params)
                .queryParam("pum_nm", coinList.getName())
                .build();

        StringReader response = new StringReader(
                restTemplate
                        .getForEntity(
                                uri.toUri(),
                                String.class)
                        .getBody()
        );

        Vegetable vegetable = (
                                (VegetableList)unmarshaller.unmarshal(response)
                                ).getVegetable();

        coinMaker.convertAndSaveVegetableToCoinData(coinList, vegetable);
    }

}
