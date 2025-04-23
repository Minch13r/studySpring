package com.example.biz.common;

import com.example.biz.board.BoardVO;
import com.example.biz.member.MemberVO;
// AspectJ의 JoinPoint 클래스 임포트 - Advice가 적용되는 지점의 정보를 담음
import org.aspectj.lang.JoinPoint;

// ReturningAdvice 클래스: AfterReturning Advice를 구현한 클래스
// 메소드가 정상적으로 실행을 마치고 값을 반환한 후에 동작함
// 반환값을 활용하여 후처리 작업을 수행할 수 있음
public class ReturningAdvice {

    // printLog 메소드: AfterReturning Advice의 로직이 구현된 메소드
    // JoinPoint: 대상 메소드의 정보를 담고 있음
    // Object returnObj: 대상 메소드가 반환한 값(XML 설정의 returning 속성과 매핑됨)
    public void printLog(JoinPoint jp, Object returnObj){

        // AfterReturning Advice 시작 메시지 출력
        System.out.println("RETURNING 공통 ");

        // 반환된 객체의 타입에 따라 다른 처리를 수행
        // instanceof 연산자로 객체의 타입을 확인

        // 반환된 객체가 BoardVO 타입인 경우
        if(returnObj instanceof BoardVO){
            // 게시판 서비스에서 반환된 경우 메시지 출력
            System.out.println("service of board");
        }

        // 반환된 객체가 MemberVO 타입인 경우
        else if(returnObj instanceof MemberVO){
            // 회원 서비스에서 반환된 경우 메시지 출력
            System.out.println("service of member");

            // returnObj를 MemberVO 타입으로 캐스팅하여 상세 정보 접근
            MemberVO vo = (MemberVO) returnObj;

            // 회원의 역할(role)에 따라 다른 메시지 출력
            if(vo.getMrole().equals("ADMIN")){
                // 관리자인 경우
                System.out.println("Admin");
            }
            else {
                // 일반 회원인 경우
                System.out.println("Member");
            }
            // 로그인 관련 메시지 출력 (로그인 서비스에서 호출된 경우)
            System.out.println("login");
        }

        // 그 외 다른 타입의 객체가 반환된 경우
        else {
            // 처리 방법을 모르는 타입인 경우 메시지 출력
            System.out.println("don't know what to do");
        }
    }
}
