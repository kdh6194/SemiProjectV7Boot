package honeybee.springbott.semiprojectv7boot.repoesitory;

import honeybee.springbott.semiprojectv7boot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    // 메서드 쿼리 findAll이 맞음
    @Query("from Member order by mbno")
    List<Member> findAll();

}
