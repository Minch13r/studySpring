package com.example.biz.common;

import com.example.biz.board.BoardVO;
import com.example.biz.member.MemberVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class CommonAdvice {
    // Before Advice - 메소드 실행 전에 동작
    public void beforeLog(JoinPoint jp) {
        System.out.println("BEFORE 공통 로그");

        // 메소드 이름 가져오기
        String methodName = jp.getSignature().getName();
        System.out.println("methodName = " + methodName);

        // 인자 정보 출력
        Object[] args = jp.getArgs();
        System.out.println("args = " + args.length);
        for(Object arg : args) {
            System.out.println(arg);
        }
    }

    // Around Advice - 메소드 실행 전후에 동작
    public Object aroundLog(ProceedingJoinPoint pjp) {
        System.out.println("AROUND 공통 로그 시작");

        StopWatch sw = new StopWatch();
        sw.start();

        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        sw.stop();
        System.out.println("AROUND 공통 로그 끝 >> " + sw.getTotalTimeMillis() + "ms");

        return result;
    }

    // AfterReturning Advice - 메소드가 정상적으로 반환된 후 동작
    public void afterReturningLog(JoinPoint jp, Object returnObj) {
        System.out.println("RETURNING 공통 ");

        if (returnObj instanceof BoardVO) {
            System.out.println("service of board");
        } else if (returnObj instanceof MemberVO) {
            System.out.println("service of member");

            MemberVO vo = (MemberVO) returnObj;
            if (vo.getMrole() != null) {
                if (vo.getMrole().equals("ADMIN")) {
                    System.out.print("Admin");
                } else if (vo.getMrole().equals("USER")) {
                    System.out.print("Member");
                }
            } else {
                System.out.println("Role is not defined");
            }
            System.out.println("login");
        } else {
            System.out.println("don't know what to do");
        }
    }

    // AfterThrowing Advice - 메소드에서 예외가 발생했을 때 동작
    public void afterThrowingLog(JoinPoint jp, Exception exceptObj) {
        System.out.println("THROWING 공통 로그");

        if(exceptObj instanceof IllegalArgumentException) {
            System.out.println("create exception");
        } else {
            System.out.println("don't find exception");
        }
    }

    // 회원가입 전용 Before Advice
    public void beforeSignupLog(JoinPoint jp) {
        System.out.println("🌟 회원가입 프로세스 시작 🌟");

        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        System.out.println("회원가입 메소드: " + methodName);
        if (args.length > 0) {
            System.out.println("회원 정보: " + args[0]);
        }
    }

    // 회원가입 후 After Advice
    public void afterSignupLog(JoinPoint jp) {
        Object[] args = jp.getArgs();

        if (args.length > 0 && args[0] instanceof MemberVO) {
            MemberVO memberVO = (MemberVO) args[0];
            String memberName = memberVO.getName();
            System.out.println("회원가입 완료: " + memberName + "님이 가입했습니다.");
        }
    }

    // LogAdvice22의 메소드도 통합
    public void printLog22() {
        System.out.println("printLog22 반환");
    }
}
