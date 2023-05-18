package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springboot.semiprojectv6.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> showBoard(int cpage);
    List<Board> showBoard(int cpage,String ftype, String fkey);
    int countBoard();
    int countBoard(String ftype, String fkey);
    boolean newBoard(Board b);
    Board readOneBoard(String bno);
}
