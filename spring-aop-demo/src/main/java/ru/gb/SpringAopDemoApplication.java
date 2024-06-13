package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.aspect.TimerAspect;
import ru.gb.demo.lesson.MyServiceBean;
import ru.gb.timer.MyServiceTime;

@SpringBootApplication
public class SpringAopDemoApplication {

	public static void main(String[] args) {

	 ConfigurableApplicationContext context = SpringApplication.run(SpringAopDemoApplication.class, args);

		MyServiceTime myServiceTime = context.getBean(MyServiceTime.class);

		myServiceTime.method1("ok", 2);
		myServiceTime.method2();

		/*MyServiceBean myServiceBean = context.getBean(MyServiceBean.class);

		myServiceBean.Method1("args1");
		myServiceBean.Method2("args2");*/
		//myServiceBean.Method1("args3");

	}

}
