package com.example.biz.common;

import com.example.biz.member.MemberVO;
import org.aspectj.lang.JoinPoint;

public class SignUpAdvice {
    public void printSignupLog(JoinPoint jp) {
        System.out.println("🌟 회원가입 프로세스 시작 🌟");

        // 메소드 이름과 파라미터 출력 (선택사항)
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        System.out.println("회원가입 메소드: " + methodName);
        if (args.length > 0) {
            System.out.println("회원 정보: " + args[0]);
        }
    }

    public void afterSignupLog(JoinPoint jp) {
        Object[] args = jp.getArgs();

        // 첫 번째 인자가 MemberVO 객체인지 확인
        if (args.length > 0 && args[0] instanceof MemberVO) {
            MemberVO memberVO = (MemberVO) args[0];
            // 회원 이름 가져오기
            String memberName = memberVO.getName();
            System.out.println("회원가입 완료: " + memberName + "님이 가입했습니다.");
        }
    }
}
