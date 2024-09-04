package org.zerock.w2.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.w2.vo.PageRequest;
import org.zerock.w2.vo.ReplyVO;

import java.util.List;

public interface ReplyMapper {

    List<ReplyVO> list(@Param("bno") Long bno, @Param("pr") PageRequest pageRequest);

    int count(@Param("bno") Long bno, @Param("pr") PageRequest pageRequest);

    int insert(ReplyVO replyVO);

}
