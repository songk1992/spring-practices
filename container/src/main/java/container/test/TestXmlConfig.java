package container.test;

import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import container.user.User;
import container.user.User1;
import container.user.User2;

public class TestXmlConfig {
	
	public static void main (String[] args) {
		
		// XML Auto Configuration (Annotation Scanning)
		// testBeanFactory01();

		// XML Bean Configuration (Annotation Scanning)
		// testBeanFactory02();
		
		// XML Auto Configuration (Annotation Scanning)
		// testApplicationContext01();

		
		// XML Bean Configuration (Annotation Scanning)
		// testApplicationContext02();
	}
	

	
	// XML Auto Configuration (Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("container/config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean의 id가 자동 생성됨
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
		
	}
	
	// XML Bean Configuration (Annotation Scanning)
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("container/config/user/applicationContext02.xml"));
		
		User2 user2 = bf.getBean(User2.class);
		System.out.println(user2.getName());

		//빈설정(Explicit Config) 에서는 Bean의 id가 자동 생성되지 않음
		// 명시적으로 설정해야 한다.
		user2 = (User2)bf.getBean("user2");
		System.out.println(user2.getName());
		
	}
	
	// XML Auto Configuration (Explicit Configuration)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("container/config/user/applicationContext01.xml");
		
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		//Bean의 id가 자동 생성됨
		user1 = (User1)ac.getBean("user1");
		System.out.println(user1.getName());
		
		// 자원 정리
		((ConfigurableApplicationContext)ac).close();
	}
	
	// XML Bean Configuration (Explicit Configuration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("container/config/user/applicationContext02.xml");
		
		// id 로 빈 가져오기
		User user = (User)ac.getBean("user");
		System.out.println(user);
		
		// name 로 빈 가져오기
		user = (User)ac.getBean("usr");
		System.out.println(user);
		
		// 1. 1개 파라미터로 생성된 빈 가져오기	
		// 2. type 로 빈 가져오기 : 
		//	- 같은 타입의 객체가 2개이상 있으면 에러
		//	- type + id 또는 type + name으로 가져 와야 한다.
		user = ac.getBean("", User.class);
		System.out.println(user);
		
		
		
		// 자원 정리
		((ConfigurableApplicationContext)ac).close();
		
	}
	
}
