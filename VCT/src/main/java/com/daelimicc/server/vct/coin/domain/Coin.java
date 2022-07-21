package com.daelimicc.server.vct.coin.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author hod0ri
 * 코인 정보 VO
 * @String coinName : 코인 이름
 * @float coinPrice : 코인 가격
 * @float coinVolume : 코인 총 개수
 *
 */

@Data
@Document(collation = "vct_coin")
public class Coin {
    @Id
    private String _id;
    private String coinName;
    private float coinPrice;
    private float coinVolume;
}
