package org.zerock.w2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.w2.dto.BoardRegisterDTO;
import org.zerock.w2.exception.DataNotFoundException;
import org.zerock.w2.mapper.BoardMapper;
import org.zerock.w2.util.UploadUtil;
import org.zerock.w2.vo.BoardVO;
import org.zerock.w2.vo.PageRequest;
import org.zerock.w2.vo.PageResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class BoardService {

    private final BoardMapper boardMapper;

    public void register(BoardRegisterDTO boardRegisterDTO) {

       java.util.List<String> uploadResult =
               UploadUtil.upload(boardRegisterDTO.getFiles());

       BoardVO boardVO = BoardVO.builder()
               .title(boardRegisterDTO.getTitle())
               .content(boardRegisterDTO.getContent())
               .writer(boardRegisterDTO.getWriter())
               .build();

       boardMapper.insert(boardVO);

       Long bno = boardVO.getBno();
       log.info("-----------------------");
       log.info(bno);

       for(int i = 0; i < uploadResult.size(); i++) {

           boardMapper.insertAttach(bno, uploadResult.get(i), i);

       }//end for

    }

    @Transactional(readOnly = true)
    public PageResponse<BoardVO> getList(PageRequest pageRequest){

        PageResponse<BoardVO> pageResponse
                = PageResponse.<BoardVO>with()
                .list(boardMapper.list(pageRequest))
                .total(boardMapper.count(pageRequest))
                .pageRequest(pageRequest)
                .build();
        return pageResponse;

    }

    public BoardVO getOne(Long bno){
        return boardMapper.select(bno).orElseThrow(
                () -> new DataNotFoundException(bno + "not found "));
    }
}
