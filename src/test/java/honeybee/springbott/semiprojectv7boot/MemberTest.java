package honeybee.springbott.semiprojectv7boot;


import honeybee.springbott.semiprojectv7boot.model.Member;
import honeybee.springbott.semiprojectv7boot.repoesitory.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class MemberTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("showall")
    public void findAllMember() {
        List<Member> mbs = memberRepository.findAll();
        System.out.println(mbs);
    }

    @Test
    @DisplayName("membersave")
    public void saveMember() {
        Member m = new Member(null,"박연진","123456","1234567","박연진","글로리","123-456","서울시 구로구 구로동","더조은","abc123@naver.com","123-456-1234",null,null,null);
        memberRepository.save(m); // 자동으로 insert문을 생성
    }

    @Test
    @DisplayName("memberupdate")
    public void updateMember() {
        Member m = new Member(2L,"문동은","123456","1234567","박연진","글로리","123-456","서울시 구로구 구로동","더조은","abc123@naver.com","123-456-1234",null,null,null);
        memberRepository.save(m); // 앞에 id가 있냐 없냐로 update와 insert구분
    }

    @Test
    @DisplayName("memberdelete")
    public void deleteMember() {
        Member m = new Member();
        m.setMbno(2L);
        memberRepository.delete(m);
    }

// findByUseridAndPasswd 이거 countByUseridAndPasswd로 바뀜
//    @Test
//    @DisplayName("member login")
//    public void loginMember() {
//        Member m = new Member();
//        m.setUserid("박연진");
//        m.setPasswd("글로리");
//
//        assertNull(memberRepository.findByUseridAndPasswd(
//                m.getUserid(), m.getPasswd()) );
//
//        m.setUserid("abc123");
//        m.setPasswd("987xyz");
//
//        assertNotNull(memberRepository.findByUseridAndPasswd(
//                m.getUserid(), m.getPasswd()) );
//    }

}
