package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	// Product 서비스에 있는 메소드가 실행되기전에
	@Before("excution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String) )")
	public void beforeAdvice() {
		System.out.println("--- before Advice ---");
	}
	
	// 생략 되는 것 "excution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String) )")
	@After("excution(* *..*.service.ProductService.*(..))") // 리턴 타입은 모든거 다 / 서비스 클래스에 있는 모든 메소드
	public void afterAdvice() {
		System.out.println("--- after Advice ---");
	}
	
	@AfterReturning("excution(* *..*.service.ProductService.*(..))") // 리턴 타입은 모든거 다 / 서비스 클래스에 있는 모든 메소드
	public void afterReturningAdvice() {
		System.out.println("--- afterReturning Advice ---");
	}
	
	@AfterThrowing(value="excution(* *..*.*.ProductService.*(..))", throwing="ex") 
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("--- afterThrowing Advice : " + ex + "---");
	}
	
	// before after 보다는 around를 많이 씀
	@Around("excution(* *..*.*.ProductService.*(..))") 
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("--- #Around(before) Advice ---");
		
		// PointCut Method 실행
		// 파라미터 가로채기
//		Object[] params = {"camera"};
//		Object result = pjp.proceed(params);
		// 실행
		Object result = pjp.proceed();
		
		System.out.println("--- #Around(after) Advice ---");
		
		return result;
	}
	
}
