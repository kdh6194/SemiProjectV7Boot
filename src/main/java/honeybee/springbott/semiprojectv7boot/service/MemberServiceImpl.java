package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springboot.semiprojectv6.dao.MemberDAO;
import honeybee.springboot.semiprojectv6.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("msrv")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO mdao;
    @Override
    public boolean checklogin(Member m, HttpSession sess) {
//        로그인 가능여부 확인
        boolean isLogin = false;
        if (mdao.selectLogin(m) > 0) {
            // 로그인 가능하면 새션변수에 아이디를 저장
            sess.setAttribute("UID",m.getUserid1());
            isLogin = true;
        }
        System.out.println(m.getUserid1());
        System.out.println(m.getPasswd1());
        return isLogin;
    }

}
