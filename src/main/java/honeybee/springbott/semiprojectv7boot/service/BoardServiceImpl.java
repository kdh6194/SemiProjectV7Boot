package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springbott.semiprojectv7boot.dao.BoardDAO;
import honeybee.springbott.semiprojectv7boot.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("bsrv")
public class BoardServiceImpl implements BoardService {
    @Autowired private BoardDAO bdao;
//    @Override
//    public List<Board> showBoard(int cpage) {
//        List<Long> stbno = Collections.singletonList((long) ((cpage - 1)*25));
//        return bdao.selectBoard(stbno);
//    }
//    @Override
//    public List<Board> showBoard(int cpage) {
//        int stbno = (cpage - 1) * 25;
//        return bdao.selectBoard(stbno);
//    }
    @Override
    public Map<String, Object> showBoard(int cpage) {
        return bdao.selectBoard(cpage-1);
    }
    @Override
    public List<Board> showBoard(int cpage, String ftype, String fkey) {
        int stbno = (cpage-1);

        // 처리시 사용할 데이터들을 해쉬맵에 담아서 보냄
        Map<String, Object> params = new HashMap<>();
        params.put("stbno",stbno);
        params.put("ftype",ftype);
        params.put("fkey",fkey);

        return bdao.selectBoard(params);
    }

//    @Override
//    public int countBoard() {
//        return bdao.countBoard();
//    }
    @Override
    public int countBoard(String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("ftype",ftype);
        params.put("fkey",fkey);
        return bdao.countBoard(params);
    }

    @Override
    public boolean newBoard(Board b) {
        boolean result = false;
        if(bdao.insertBoard(b) > 0) {
            result = true;
        }
        return result;
    }
//    @Override
//    public Board readOneBoard(long bno) {
//        return bdao.selectOneBoard(bno);
//    }
    @Override
    public Board readOneBoard(int bno) {
        return bdao.selectOneBoard(bno);
    }
}
