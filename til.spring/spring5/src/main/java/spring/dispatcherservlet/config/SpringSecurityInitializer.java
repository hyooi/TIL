package spring.dispatcherservlet.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 스프링 시큐리티는 DelegatingFilterProxy를 implement해서 사용
 * 이를 위해, 스프링 컨테이너에서 AbstractSecurityWebApplicationInitializer를 이용함
 *
 * 어플리케이션을 시작하 때, 해당 클래스를 발견하고 다른 필터가 등록되기 전에 DelegatingilterProxy를 등록함
 * 또한 ContextLoaderListener를 등록
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
