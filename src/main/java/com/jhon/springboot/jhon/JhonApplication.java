package com.jhon.springboot.jhon;

import com.jhon.springboot.jhon.component.ComponentDependecy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JhonApplication implements CommandLineRunner {

	private ComponentDependecy componentDependecy;

	public JhonApplication(@Qualifier("componentTwoImplement") ComponentDependecy componentDependecy){
		this.componentDependecy = componentDependecy;
	}
	public static void main(String[] args) {
		SpringApplication.run(JhonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependecy.saludar();
	}
}
