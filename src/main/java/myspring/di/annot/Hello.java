package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//helloBean으로 id를 줌	(spring-beans.xml 의 hello 가 id인 bean을 helloBean라고 함)
@Component("helloBean")
public class Hello {
	
	//spring-beans.xml의 <property name="name" value="스프링"> 코드를
	@Value("어노테이션")	//코드로 변환 가능
	String name;

	//spring-beans.xml의 <property name="printer" ref="strPrinter" > 코드를
	@Autowired
	@Qualifier("stringPrinter")	//어떤 Printer 타입의 객체인지 모르니까 명확하게 알려주는 것
	Printer printer;
	
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName() + "생성자 호출됨");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName() + "오버로딩된 생성자 호출됨");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		System.out.println("Hello setNames()" + list);
		this.names = list;
	}
	
	
//
//	public void setName(String name) {
//		System.out.println("Hello setName() " + name);
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {
//		System.out.println("Hello setPrinter() " + printer.getClass().getName());
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
