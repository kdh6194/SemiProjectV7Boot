package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Board;

import honeybee.springbott.semiprojectv7boot.repoesitory.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionScoped;
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
        // 페이징시 정렬하는 방식
        Pageable paging = PageRequest.of(cpage,25, Sort.by("bno").descending());
        return boardRepository.findAll(paging).getContent();
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {

        // like 검색에 대한 query method
        // findByTitleLike       : %검색어% (% 문자 제공 필요)
        // findByTitleContains   : %검색어% (% 문자 제공 필요x)
        // findByTitleStartsWith : 검색어% (% 문자 제공 필요x)
        // findByTitleEndsWith   : %검색어 (% 문자 제공 필요x)

//        String fkey = "%" + params.get("fkey").toString() +"%" ;
        String ftype = params.get("ftype").toString();
        String fkey =  params.get("fkey").toString() ;
        int cpage = (int) params.get("stbno");
        Pageable paging = PageRequest.of(cpage,25, Sort.by("bno").descending());

        List<Board> result = null;

        switch (ftype) {
            case "title" :
                // 제목으로 검색
//                result = boardRepository.findByTitleLike(paging, fkey); break;
                  result = boardRepository.findByTitleContains(paging, fkey); break;
            case "titcont" :
                // 제목+본문으로 검색
//                result = boardRepository.findByTitleLikeOrContentLike(paging, fkey, fkey); break;
                  result = boardRepository.findByTitleContainsOrContentContains(paging, fkey, fkey); break;
            case "content" :
                // 본문으로 검색
//                result = boardRepository.findByContentLike(paging, fkey); break;
                  result = boardRepository.findByContentContains(paging, fkey); break;
            case "userid" :
                // 작성자으로 검색
//                fkey = fkey.replace("%", "");  -> like에 대한 잔재
                  result = boardRepository.findByUserid(paging, fkey);

        }
        return result;
    }

    @Override
    public int countBoard() {
        // select ceil(count(bno)/25) from board
        int allcnt = boardRepository.countBoardBy();
        return (int) Math.ceil( allcnt / 25 );
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        String ftype = params.get("ftype").toString();
        String fkey =  params.get("fkey").toString() ;
        int cnt = 0;

        switch (ftype) {
            case "title" :
                // 제목으로 검색
                cnt = boardRepository.countByTitleContains(fkey); break;
            case "titcont" :
                // 제목+본문으로 검색
                cnt = boardRepository.countByTitleContainsOrContentContains(fkey, fkey); break;
            case "content" :
                // 본문으로 검색
                cnt = boardRepository.countByContentContains(fkey); break;
            case "userid" :
                // 작성자으로 검색
                cnt = boardRepository.countByUserid(fkey);

        }
        return (int) Math.ceil( cnt / 25 );
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
