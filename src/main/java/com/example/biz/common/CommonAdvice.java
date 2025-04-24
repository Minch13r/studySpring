package com.example.biz.common;

import com.example.biz.board.BoardVO;
import com.example.biz.member.MemberVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class CommonAdvice {
    // Before Advice - 메소드 실행 전에 동작
    public void beforeLog(JoinPoint jp) {
        System.out.println("================================");
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
        System.out.println("================================");
    }

    // Around Advice - 메소드 실행 전후에 동작
    public Object aroundLog(ProceedingJoinPoint pjp) {
        System.out.println("================================");
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
        System.out.println("================================");
        return result;
    }

    // AfterReturning Advice - 메소드가 정상적으로 반환된 후 동작
    public void afterReturningLog(JoinPoint jp, Object returnObj) {
        System.out.println("================================");
        System.out.println("RETURNING 공통 ");

        if (returnObj instanceof MemberVO) {
            // 회원 서비스에서 반환된 경우 메시지 출력
            System.out.println("RETURNING 공통 로그");

            // returnObj를 MemberVO 타입으로 캐스팅하여 상세 정보 접근
            MemberVO vo = (MemberVO) returnObj;

            // 회원의 역할(role)에 따라 다른 메시지 출력
            if (vo.getMrole().equals("ADMIN")) {
                // 관리자인 경우
                System.out.print("ADMIN ");
            }
            else {
                // 일반 회원인 경우
                throw new IllegalArgumentException("USER LOGIN");
//               System.out.print("사용자가 ");
            }
            // 로그인 관련 메시지 출력 (로그인 서비스에서 호출된 경우)
            System.out.println("LOGIN");
        }
        System.out.println("================================");
    }

    // AfterThrowing Advice - 메소드에서 예외가 발생했을 때 동작
    public void afterThrowingLog(JoinPoint jp, Exception exceptObj) {
        System.out.println("================================");
        System.out.println("THROWING 공통 로그");

        if(exceptObj instanceof IllegalArgumentException) {
            System.out.println("create exception");
        } else {
            System.out.println("don't find exception");
        }
        System.out.println("================================");
    }

    // 회원가입 전용 Before Advice
    public void beforeSignupLog(JoinPoint jp) {
        System.out.println("================================");
        System.out.println("🌟 회원가입 프로세스 시작 🌟");

        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        System.out.println("회원가입 메소드: " + methodName);
        if (args.length > 0) {
            System.out.println("회원 정보: " + args[0]);
        }
        System.out.println("================================");
    }

    // 회원가입 후 After Advice
    public void afterSignupLog(JoinPoint jp) {
        System.out.println("================================");
        Object[] args = jp.getArgs();

        if (args.length > 0 && args[0] instanceof MemberVO) {
            MemberVO memberVO = (MemberVO) args[0];
            String memberName = memberVO.getName();
            System.out.println("회원가입 완료: " + memberName + "님이 가입했습니다.");
        }
        System.out.println("================================");
    }

    // LogAdvice22의 메소드도 통합
    public void printLog22() {
        System.out.println("================================");
        System.out.println("printLog22 반환");
        System.out.println("================================");
    }
}
