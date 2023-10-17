package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy2.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-bean-Configuration.xml")
public class AnnotatedConfiguration {
	@Autowired
	UserServiceImpl service;
	
	
	@Test
	public void test() {
		System.out.println(service.getUserList());
	}
}
