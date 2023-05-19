package honeybee.springbott.semiprojectv7boot.repoesitory;

import honeybee.springbott.semiprojectv7boot.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//public interface BoardRepository extends JpaRepository<Board, Long> {
public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {

//    List<Board> findAllById(Iterable<Long> longs);
    List<Board> findAllById(int longs);

    // JpaRepository 에서는 DML은 지원 X
    // 단, Modifying, Transactional등을 추가하면 사용가능
    @Modifying
    @Transactional
    @Query(
            "update Board set views = views + 1 where bno = :bno")
    int countViewBoard(@Param("bno") long bno);
}
