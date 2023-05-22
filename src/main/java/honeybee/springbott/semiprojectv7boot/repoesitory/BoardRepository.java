package honeybee.springbott.semiprojectv7boot.repoesitory;

import honeybee.springbott.semiprojectv7boot.model.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//public interface BoardRepository extends JpaRepository<Board, Long> {
public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {


    // JpaRepository 에서는 DML은 지원 X
    // 단, Modifying, Transactional등을 추가하면 사용가능
    @Modifying
    @Transactional
    @Query(
            "update Board set views = views + 1 where bno = :bno")
    int countViewBoard(@Param("bno") long bno);

    //@Query("select ceil(count(bno)/25) from Board")
    int countBoardBy();

    // like로 작업했을 때 사용한 구문
//    List<Board> findByTitleLike(Pageable paging,String fkey);
//    List<Board> findByTitleLikeOrContentLike(Pageable paging, String fkey1, String fkey2);
//    List<Board> findByUserid(Pageable paging, String fkey);
//    List<Board> findByContentLike(Pageable paging, String fkey);

    // Contains 사용한 구문
    List<Board>findByTitleContains(Pageable paging,String fkey);
    List<Board>findByTitleContainsOrContentContains(Pageable paging, String fkey1, String fkey2);
    List<Board>findByContentContains(Pageable paging,String fkey);
    List<Board>findByUserid(Pageable paging,String fkey);

    int countByTitleContains(String fkey);

    int countByTitleContainsOrContentContains(String fkey1, String fkey2);

    int countByContentContains(String fkey);

    int countByUserid(String fkey);
}