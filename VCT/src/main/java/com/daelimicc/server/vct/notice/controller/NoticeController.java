package com.daelimicc.server.vct.notice.controller;

import com.daelimicc.server.vct.notice.domain.Notice;
import com.daelimicc.server.vct.notice.dto.NoticeDTO;
import com.daelimicc.server.vct.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @PostMapping("")
    public Notice recordNotice(@RequestBody NoticeDTO noticeDTO) {
        return noticeRepository.save(noticeDTO.toEntity());
    }
    //    @GetMapping("/all")
//    public List<Notice> getCoinList() {
//        return  noticeRepository.findAll(Sort.by(Sort.Direction.DESC,"noticeCrtDttm"));
//    }


//    @GetMapping("")
//    public Notice getNoticeList(@RequestParam(value = "nt") String noticeTitle) {
//        return noticeRepository.findByNoticeTitle(noticeTitle);
//    }

    @GetMapping("")
    public List<Notice> getFindNotice(@RequestParam(required = false) String noticeTitle,
                                      @RequestParam(required = false) String noticeContents) {

        return noticeRepository.findByNoticeTitleOrNoticeContents(noticeTitle, noticeContents);

    }
//    @GetMapping("")
//    public List<Notice> getFindNotice(@RequestParam(value = "nt", required = false) String noticeTitle) {
//        return noticeRepository.findByNoticeTitle(noticeTitle);
//    }

        @PutMapping("")
    public ResponseEntity<Notice> updateNotice(@RequestBody NoticeDTO noticeDTO, @RequestParam(value = "id") String _id) {

        Notice notice = noticeDTO.toEntity();
        notice.set_id(_id);
        return new ResponseEntity<>(noticeRepository.save(notice), HttpStatus.OK);
    }
//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<Notice> updateNotice(@PathVariable("id") String _id, @RequestBody Notice notice) {
//        Optional<Notice> noticeData = noticeRepository.findById(_id);
//        if (noticeData.isPresent()) {
//            Notice _notice = noticeData.get();
//            _notice.setNoticeTitle(notice.getNoticeTitle());
//            _notice.setNoticeContents(notice.getNoticeContents());
//            return new ResponseEntity<>(noticeRepository.save(_notice), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    @DeleteMapping("")
    public List<Notice> deleteNotice(@RequestParam(value = "id") String _id){
        return noticeRepository.deleteNoticeBy_id(_id);
    }

}
