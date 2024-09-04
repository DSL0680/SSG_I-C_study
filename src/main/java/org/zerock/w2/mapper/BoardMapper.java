package org.zerock.w2.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.zerock.w2.vo.BoardVO;
import org.zerock.w2.vo.PageRequest;

import java.util.Optional;

public interface BoardMapper {

    java.util.List<BoardVO> list(PageRequest pageRequest);

    int count(PageRequest pageRequest);

    Long insert(BoardVO vo);

    void insertAttach(@Param("bno") Long bno,
                      @Param("fileName") String fileName,
                      @Param("ord") int ord);

    int delete(Long bno);

    int update(BoardVO vo);

    Optional<BoardVO> select(Long bno);

    @Update("update tbl_board set replyCnt = replyCnt + #{amount} where bno = #{bno}")
    int updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
