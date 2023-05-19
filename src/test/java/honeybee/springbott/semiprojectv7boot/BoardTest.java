package honeybee.springbott.semiprojectv7boot;


import honeybee.springbott.semiprojectv7boot.model.Board;
import honeybee.springbott.semiprojectv7boot.repoesitory.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class BoardTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("showall")
    public void findAllBoard() {
        List<Board> bbs = boardRepository.findAllById();
        System.out.println(bbs);
    }

    @Test
    @DisplayName("boardsave")
    public void saveBoard() {
        Board b = new Board(null,"test","test",0,0,"test",null);
        boardRepository.save(b); // 자동으로 insert문을 생성
    }

    @Test
    @DisplayName("boardupdate")
    public void updateBoard() {
        Board b = new Board(2L,"운영자가 누구세요","전재준",0,0,"네비찍고 차 타고왔다",null);
        boardRepository.save(b); // 앞에 id가 있냐 없냐로 update와 insert구분
    }

    @Test
    @DisplayName("boarddelete")
    public void deleteBoard() {
        Board b = new Board();
        b.setBno(2L);
        boardRepository.delete(b);
    }

}
