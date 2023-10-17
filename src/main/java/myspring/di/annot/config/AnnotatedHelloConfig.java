package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Configuration => xml을 대신해서 설정역할을 하는 클래스라는 의미
@ComponentScan(basePackages = {"myspring.di.annot"})
public class AnnotatedHelloConfig {
	
}
