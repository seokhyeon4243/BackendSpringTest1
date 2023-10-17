package myspring.di.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.strategy1.service.UserService;

public class StuBeanJunitTest {
	
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		factory = new GenericXmlApplicationContext("classpath:spring-bean-Configuration.xml");
	}
	
	@Test
	void test() {
		UserService service = (UserService)factory.getBean("userServiceImpl");
		System.out.println(service.getUserList());
	}
}
