package com.daelimicc.server.vct.notice.controller;

import com.daelimicc.server.vct.notice.domain.Notice;
import com.daelimicc.server.vct.notice.dto.NoticeDTO;
import com.daelimicc.server.vct.notice.repository.NoticeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    /**
     * 게시판 생성
     * @param noticeDTO 게시판 정보
     * @return 게시판 생성 결과
     */
    @ApiOperation(value = "게시판 생성")
    @PostMapping("")
    public Notice recordNotice(@RequestBody NoticeDTO noticeDTO) {
        return noticeRepository.save(noticeDTO.toEntity());
    }

    /**
     * 특정 게시판 정보 불러오기
     * @param _id 게시판 아이디
     * @return 게시판 정보
     */
    @ApiOperation(value = "게시판 검색")
    @GetMapping("/{id}")
    public Notice findByNoticeId(@RequestParam(value = "id") String _id) {
        return noticeRepository.findById(_id).get();
    }

    /**
     * 모든 게시판 정보 불러오기
     * @return 게시판 정보 목록
     */
    @ApiOperation(value = "게시판 전체")
    @GetMapping("/all")
    public List<Notice> findNoticeAll() {
        return noticeRepository.findAll(Sort.by(Sort.Direction.DESC,"noticeCrtDttm"));
    }

    /**
     * 게시판 정보 수정
     * @param noticeDTO 게시판 정보
     * @param _id 게시판 아이디
     */
    @ApiOperation(value = "게시판 수정")
    @PutMapping("")
    public ResponseEntity<Notice> updateNotice(@RequestBody NoticeDTO noticeDTO,
                                               @RequestParam(value = "id") String _id) {

        Notice notice = noticeDTO.toEntity();
        notice.set_id(_id);
        return new ResponseEntity<>(noticeRepository.save(notice), HttpStatus.OK);
    }

    /**
     * 게시판 삭제
     * @param _id 게시판 아이디
     */
    @ApiOperation(value = "게시판 삭제")
    @DeleteMapping("")
    public List<Notice> deleteNotice(@RequestParam(value = "id") String _id){
        return noticeRepository.deleteNoticeBy_id(_id);
    }

}
