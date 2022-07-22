package com.daelimicc.server.vct.notice.controller;

import com.daelimicc.server.vct.notice.domain.Notice;
import com.daelimicc.server.vct.notice.dto.NoticeDTO;
import com.daelimicc.server.vct.notice.repository.NoticeRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
@Api(tags = "공지사항 게시판 CRUD API")
public class NoticeController {
    private final NoticeRepository noticeRepository;

    @PostMapping("")
    public Notice recordNotice(@RequestBody NoticeDTO noticeDTO) {
        return noticeRepository.save(noticeDTO.toEntity());
    }

    @GetMapping("/{id}")
    public Notice findByNoticeId(@PathVariable String id) {
        return noticeRepository.findById(id).get();
    }
    @GetMapping("/all")
    public List<Notice> findNoticeAll() {
        return noticeRepository.findAll(Sort.by(Sort.Direction.DESC,"noticeCrtDttm"));
    }




    @PutMapping("")
    public ResponseEntity<Notice> updateNotice(@RequestBody NoticeDTO noticeDTO,
                                               @RequestParam(value = "id") String _id) {

        Notice notice = noticeDTO.toEntity();
        notice.set_id(_id);
        return new ResponseEntity<>(noticeRepository.save(notice), HttpStatus.OK);
    }

    @DeleteMapping("")
    public List<Notice> deleteNotice(@RequestParam(value = "id") String _id){
        return noticeRepository.deleteNoticeBy_id(_id);
    }

}
