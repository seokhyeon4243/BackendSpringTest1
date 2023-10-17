package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.dao.UserDaoImpl;
import myspring.di.strategy1.service.UserServiceImpl;

@Configuration
public class XmlConfig {
	
	@Bean
	public UserDao userdao() {
		return new UserDaoImpl();
	}

	@Bean
	public UserServiceImpl service() {
		UserServiceImpl service = new UserServiceImpl();
		service.setUserdao(userdao());
		return service;
	}
}
