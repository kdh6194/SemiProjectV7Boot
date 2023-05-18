package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {
    @Override
    public int selectLogin(Member m){
        return 0;
    };
}
