package com.daelimicc.server.vct.wallet.dto;

import com.daelimicc.server.vct.wallet.domain.Wallet;
import lombok.Data;


@Data
public class WalletDTO {

    private String _id;
    private String name;

    public Wallet toEntity(){
        Wallet wallet = new Wallet();
        wallet.set_id(_id);
        wallet.setName(name);
        return wallet;
    }


}
