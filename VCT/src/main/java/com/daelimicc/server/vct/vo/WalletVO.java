package com.daelimicc.server.vct.vo;

import lombok.Getter;
import lombok.Setter;


/**
 * @author hod0ri
 * 사용자 지갑 내용물 VO
 * @String coinName : 보유 코인 명칭
 * @String coinAmount : 보유 코인 개수
 * @String restPoint : 잔여 보유 포인트
 * @String createAt : 지갑 생성 시간
 * @String updateAt : 지갑 갱신 시간
 */
@Getter
@Setter
public class WalletVO {
    private String coinName;
    private String coinAmount;
    private String restPoint;
    private String createdAt;
    private String updatedAt;
}
