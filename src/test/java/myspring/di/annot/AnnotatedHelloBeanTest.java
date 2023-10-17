package myspring.di.annot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= "classpath:spring-beans-annot.xml")

public class AnnotatedHelloBeanTest {
	@Autowired
	Hello hello;	//Autowired는 타입을 기반으로 하기 때문에 hello가 하나밖에 없으므로 상관없음
	
	@Resource(name = "stringPrinter")
	Printer printer;
	
	@Autowired
	HelloCons helloCons;
	
	@Test
	public void helloConsBean() {
		Assertions.assertEquals("Hello annot생성자", helloCons.sayHello());
		helloCons.print();
	}
	
	@Test
	public void helloBean() {
		Assertions.assertEquals("Hello 어노테이션", hello.sayHello());
		//Printer에서 print메소드의 message를 버퍼에 쌓기 위해서 print() 메소드를 실행
		hello.print();
		Assertions.assertEquals("Hello 어노테이션", printer.toString());
	}
}
