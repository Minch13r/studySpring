package com.example.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// PoincutCommon은 메서드를 .aPointcut() 이런식으로 쓰지 않기에 new 안 해도 됨
// @Component 이런거 안 써도 됨.
public class PointcutCommon {
    // 결합도를 낮추고 응집도를 높임
    // 반복되는 코드를 줄였으니 결합도를 낮춤
    // 관련있는 코드들끼리 묶어봤기에 응집도를 높임

    // aPointcut 만들기(get만 허용)
    @Pointcut("execution(* com.example.biz..*Impl.get*(..))")
    public void aPointcut() {
    }

    // bPointcut 만들기(모든 메서드 허용)
    @Pointcut("execution(* com.example.biz..*Impl.*(..))")
    public void bPointcut() {
    }

    // 회원가입 관련 pointcut
    @Pointcut("execution(* com.example.biz.member.impl.*Impl.insert(..))")
    public void signupPointcut(){
    }
}
