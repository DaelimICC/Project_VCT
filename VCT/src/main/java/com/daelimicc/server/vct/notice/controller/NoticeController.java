package com.daelimicc.server.vct.notice.controller;

import com.daelimicc.server.vct.notice.domain.Notice;
import com.daelimicc.server.vct.notice.dto.NoticeDTO;
import com.daelimicc.server.vct.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @PostMapping("")
    public Notice recordNotice(@RequestBody NoticeDTO noticeDTO) {
        return noticeRepository.save(noticeDTO.toEntity());
    }

}
