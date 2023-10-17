package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.annot.HelloCons;

//기존의 new GenericXmlApplicationContext 
@ExtendWith(SpringExtension.class)
//기존의 classpath:spring-beans.xml
@ContextConfiguration(locations = "classpath:spring-beans.xml")

public class HelloBeanSpringTest {
	
	//변수명을 맞추고 Hello 를 가져오는 경우
	@Autowired
	Hello hello;	//spring-beans.xml의 bean id와 일치해야 됨
	

	//변수명을 맞추지 않고 HelloC를 가져오는 경우
	//Qualifier 를 항상 같이 써야 됨
	@Autowired
	@Qualifier("helloC")
	Hello hello2;
	
	//bean의 일치하는 id로 가져옴
	@Resource(name = "helloC")
	Hello hello3;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	
	@Test
	public void helloC() {
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
	}
	
	@Test //@Disabled
	public void hello() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
	}
}
