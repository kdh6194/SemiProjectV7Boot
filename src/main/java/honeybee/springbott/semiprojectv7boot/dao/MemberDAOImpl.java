package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Member;

import honeybee.springbott.semiprojectv7boot.repoesitory.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    MemberRepository memberRepository;
//    @Override
//    public int selectLogin(Member m){
//        int isLogin = -1;
//
//        if(memberRepository.findByUseridAndPasswd(
//                m.getUserid(),m.getPasswd()) != null)
//            isLogin = 1;
//
//        return isLogin;
//    };

    @Override
    public int selectLogin(Member m){
       return memberRepository.countByUseridAndPasswd(m.getUserid(),m.getPasswd());
    };
}
