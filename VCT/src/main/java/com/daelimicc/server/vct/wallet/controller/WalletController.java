package com.daelimicc.server.vct.wallet.controller;

import com.daelimicc.server.vct.wallet.domain.Wallet;
import com.daelimicc.server.vct.wallet.dto.WalletDTO;
import com.daelimicc.server.vct.wallet.repository.WalletRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
@Api(tags = "사용자 지갑 API")
public class WalletController {

}
