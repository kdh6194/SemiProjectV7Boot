package honeybee.springbott.semiprojectv7boot.repository;

import honeybee.springbott.semiprojectv7boot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

//    Member findByUseridAndPasswd(String userid, String passwd);

    int countByUseridAndPasswd(String userid, String passwd);

}
