package honeybee.springbott.semiprojectv7boot.dao;


import honeybee.springbott.semiprojectv7boot.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
//    List<Board> selectBoard(Iterable<Long> stbno);
//    List<Board> selectBoard(int stbno);
    Map<String,Object> selectBoard(int cpage);
    Map<String,Object> selectBoard(Map<String,Object> params);
//    int countBoard();
//    int countBoard(Map<String,Object> params);
    int insertBoard(Board b);
//    Board selectOneBoard(long bno);
    Board selectOneBoard(int bno);
}
