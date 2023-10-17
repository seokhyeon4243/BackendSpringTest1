package myspring.di.xml.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy1.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = XmlConfig.class)
public class XmlConfigurate {
	@Autowired
	UserService service;
	
	@Test
	public void test() {
		System.out.println(service.getUserList());
	}
}
