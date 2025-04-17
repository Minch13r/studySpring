package com.example.view.member;

import com.example.biz.member.MemberService;
import com.example.biz.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;
//    @Autowired
//    private HttpSession session;
    // DI하는 것보다 login 인자로 넣는게 더 나음
    // 왜냐하면 인자로 넣으면 컨테이너에서 다 new 해주는데 @Autowired 쓰면 어디선가 new 해야하기 때문
    // session을 모든 파일에서 다 쓰는게 아니라서 인자로 넣는게 훨씬 더 가벼움

    //  GET, POST 방식 두개 다
    //@RequestMapping(value="/login.do")// 메소드 위에다가 붙여서 올려야 함
    //@RequestMapping(value="login.do", method=RequestMethod.POST) // 이거는 POST 형식 RequestMapping
    @PostMapping("/login.do")
    // request는 Spring Container에서 new 해줌 그러니까 new 하고 싶은거 다 넣어버리셈 VO처럼
    public String login(MemberVO memberVO, HttpSession session) {
        System.out.println("Login Controller executed");

        // 아이디랑 이름 세션에 저장
        session.setAttribute("mid", memberVO.getMid());
        session.setAttribute("name", memberVO.getName());

        // Spring 컨테이너에서 parameter 다 해줌. 값 있는게 있으면 다 해줌
//        memberVO.setMid(request.getParameter("mid"));
//        memberVO.setMpw(request.getParameter("mpw"));
        // 이거까지 지우면 완전 POJO 되는거임

        // 페이지 이동 처리
        String path = "redirect:login.do";
        // 로그인 성공시 메인페이지 이동
        if(memberService.getMember(memberVO) != null) {
            // redirect 하고 싶으면 앞에 명시해줘야 함
            path = "redirect:main.do";
        }
        return path;
    }

    // POST만 있으면 404발생, GET도 있어야 함.
    @GetMapping("/login.do")
    public String loginPage(){
        return "login";
    }


    @GetMapping("/logout.do")
    public String logout(){
        return "redirect:login.do";
    }
}
