package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Board;

import honeybee.springbott.semiprojectv7boot.repoesitory.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("bdao")
public class BoardDAOImpl implements BoardDAO {
    @Autowired
    BoardRepository boardRepository;

//    @Override
//    public List<Board> selectBoard(Iterable<Long> stbno) {
//        return boardRepository.findAllById(stbno);
//    }

//    @Override
//    public List<Board> selectBoard(int stbno) {
//        return boardRepository.findAll();
//    }

    @Override
    public List<Board> selectBoard(int cpage) {
        Pageable paging = PageRequest.of(cpage,25);
        return boardRepository.findAll(paging).getContent();
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {
        return null;
    }

    @Override
    public int countBoard() {
        return 0;
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int insertBoard(Board b) {

        return Math.toIntExact(boardRepository.save(b).getBno());
    }

//    @Override
//    public Board selectOneBoard(long bno) {
//        return null;
//    }

    @Override
    public Board selectOneBoard(int bno) {
        boardRepository.countViewBoard((long) bno);
        return boardRepository.findById((long) bno).get();
    }
}
