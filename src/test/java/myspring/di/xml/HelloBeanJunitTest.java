package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class HelloBeanJunitTest {
	
	BeanFactory factory;

	
	//Test 케이스를 생성하기 전에 미리 컨테이너를 생성
	@BeforeEach
	void init() {
		// 1. Spring Bean Container 객체 생성	(컨테이너 생성)
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	
	@Test //@Disabled
	void 생성자주입테스트() {
		Hello bean = factory.getBean("helloC", Hello.class);
		assertEquals("Hello 생성자", bean.sayHello());
		bean.print();
		
		List<String> names = bean.getNames();
		
		assertEquals(3, names.size());
		assertEquals("SpringBoot", names.get(1));
		
	}
	
	// Disabled 어노테이션을 하면 일시적으로 실행되지 않게 함
	@Test @Disabled
	void hello() {
		
		// 2. Container가 생성한 Bean을 요청하기
		Hello hello1 = (Hello)factory.getBean("hello");	//casting
		Hello hello2 = factory.getBean("hello", Hello.class);//타입 주기
		
		// 3. HelloBean 래퍼런스 비교하기 (싱글톤인지 확인하기 위해서 비교)
		System.out.println(hello1 == hello2);
		assertSame(hello1, hello2);	//주소가 같은지 비교
		
		assertEquals("Hello 스프링", hello2.sayHello());	//값이 같은지 비교
		hello2.print();
		
		Printer printer = factory.getBean("strPrinter", Printer.class);	//다형성
		assertEquals("Hello 스프링", printer.toString());
		
		
	}
}
