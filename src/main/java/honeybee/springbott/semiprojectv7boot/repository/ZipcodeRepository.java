package honeybee.springbott.semiprojectv7boot.repository;

import honeybee.springbott.semiprojectv7boot.model.Zipcode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


//public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {
public interface ZipcodeRepository extends PagingAndSortingRepository<Zipcode, Long> {
    // JpaRepository<VO클래스명, 해당클래스 ID>
    // 메서드 쿼리를 사용하다가
    // 다 커버가 안될때는 직적쿼리문을 작성하여 사용

    // 메서드 쿼리 : find엔티티명All, find엔티티명By컬럼명
    @Query("from Zipcode where dong like %:dong% ")
    List<Zipcode> findZipcodeByDong(@Param("dong") String dong);
//  인자에 받은 값을 @param를 통해 @query에 값이 전달되는 방식


    // 전체 조회 중 페이징
    Page<Zipcode> findAll(Pageable pageable);

    // 검색 중 페이징
    Page<Zipcode> findByDongLike(String dong, Pageable pageable);

}
