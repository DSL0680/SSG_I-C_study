package org.zerock.w2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.w2.mapper.ReplyMapper;
import org.zerock.w2.vo.PageRequest;
import org.zerock.w2.vo.PageResponse;
import org.zerock.w2.vo.ReplyVO;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;

    public PageResponse<ReplyVO> getList(Long bno, PageRequest pageRequest) {

        return PageResponse.<ReplyVO>with()
                .list(replyMapper.list(bno, pageRequest))
                .total(replyMapper.count(bno, pageRequest))
                .pageRequest(pageRequest)
                .build();

    }

}
