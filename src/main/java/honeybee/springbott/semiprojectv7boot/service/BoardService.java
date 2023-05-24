package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springbott.semiprojectv7boot.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {
    Map<String, Object> showBoard(int cpage);
    Map<String, Object> showBoard(int cpage,String ftype, String fkey);
//    int countBoard();
//    int countBoard(String ftype, String fkey);
    boolean newBoard(Board b);
//    Board readOneBoard(long bno);
    Board readOneBoard(int bno);
}
