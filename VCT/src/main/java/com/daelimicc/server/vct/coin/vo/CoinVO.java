package com.daelimicc.server.vct.coin.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hod0ri
 * 코인 정보 VO
 * @String coinName : 코인 이름
 * @String coinPrice : 코인 가격
 * @String coinVolume : 코인 총 개수
 * @String coinCreateAt : 코인 생성 시간
 *
 */
@Getter
@Setter
public class CoinVO {
    private String coinName;
    private String coinPrice;
    private String coinVolume;
    private String coinCreatedAt;
}
