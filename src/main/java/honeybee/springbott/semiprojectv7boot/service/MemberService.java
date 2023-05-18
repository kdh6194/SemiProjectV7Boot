package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springbott.semiprojectv7boot.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberService {

    boolean checklogin(Member m, HttpSession sess);
}
