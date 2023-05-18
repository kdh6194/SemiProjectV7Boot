package honeybee.springbott.semiprojectv7boot.repoesitory;

import honeybee.springbott.semiprojectv7boot.model.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {
    // JpaRepository<VO클래스명, 해당클래스 ID>
    // 메서드 쿼리를 사용하다가
    // 다 커버가 안될때는 직적쿼리문을 작성하여 사용

    // 메서드 쿼리 : find엔티티명All, find엔티티명By컬럼명
    @Query("from Zipcode where dong like %:dong% ")
    List<Zipcode> findZipcodeByDong(@Param("dong") String dong);
//  인자에 받은 값을 @param를 통해 @query에 값이 전달되는 방식


}
