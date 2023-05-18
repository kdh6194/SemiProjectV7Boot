package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    SqlSession sqlSession;
    @Override
    public int selectLogin(Member m) {
        return sqlSession.selectOne("member.selectlogin",m);
    }
}
