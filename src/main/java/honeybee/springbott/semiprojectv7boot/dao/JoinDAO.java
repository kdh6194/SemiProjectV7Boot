package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springboot.semiprojectv6.model.Member;
import honeybee.springboot.semiprojectv6.model.Zipcode;

import java.util.List;

public interface JoinDAO {
    List<Zipcode> selectZipcode(String dong);

    int insertMember(Member m);

    int selectOneUserid(String uid);

    int selectOneMember(Member m);
}
