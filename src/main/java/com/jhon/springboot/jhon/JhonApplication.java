package com.jhon.springboot.jhon;

import com.jhon.springboot.jhon.bean.MyBean;
import com.jhon.springboot.jhon.bean.MyBeanWithDependency;
import com.jhon.springboot.jhon.bean.MyBeanWithProperties;
import com.jhon.springboot.jhon.component.ComponentDependecy;
import com.jhon.springboot.jhon.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JhonApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(JhonApplication.class);
	private ComponentDependecy componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public JhonApplication(@Qualifier("componentTwoImplement") ComponentDependecy componentDependecy,
						   MyBean myBean, MyBeanWithDependency myBeanWithDependency,
						   MyBeanWithProperties myBeanWithProperties,
						   UserPojo userPojo){
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(JhonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWithDepency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword());
		LOGGER.error("error--->");
	}
}
