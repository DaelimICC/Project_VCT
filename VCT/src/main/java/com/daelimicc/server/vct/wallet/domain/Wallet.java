package com.daelimicc.server.vct.wallet.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "vct_wallet")
@Data
public class Wallet {

    @Id
    private String _id;
    private String name;



}
