package org.zerock.w2.mapper;


import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.w2.vo.ReplyVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class ReplyMapperTests {

    @Autowired(required = false)
    private BoardMapper boardMapper;
    @Autowired(required = false)
    private ReplyMapper replyMapper;

    @Test
    public void testInsert() {

        Long bno = 23L;

        ReplyVO vo = ReplyVO.builder()
                .bno(bno)
                .reply("Sample...")
                .replyer("r1")
                .build();

        replyMapper.insert(vo);
        boardMapper.updateReplyCnt(bno, 1);

    }

}
