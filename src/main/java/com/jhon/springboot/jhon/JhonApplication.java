package com.jhon.springboot.jhon;

import com.jhon.springboot.jhon.bean.MyBean;
import com.jhon.springboot.jhon.bean.MyBeanWithDependency;
import com.jhon.springboot.jhon.bean.MyBeanWithProperties;
import com.jhon.springboot.jhon.component.ComponentDependecy;
import com.jhon.springboot.jhon.entity.User;
import com.jhon.springboot.jhon.pojo.UserPojo;
import com.jhon.springboot.jhon.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JhonApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(JhonApplication.class);
	private ComponentDependecy componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public JhonApplication(@Qualifier("componentTwoImplement") ComponentDependecy componentDependecy,
						   MyBean myBean, MyBeanWithDependency myBeanWithDependency,
						   MyBeanWithProperties myBeanWithProperties,
						   UserPojo userPojo,
						   UserRepository userRepository){
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(JhonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemploClasesAnteriores();
		saveUserInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info("user:"+
				userRepository.findMyUserByEmail("jhon.ochoa@unillanos.edu.co")
						.orElseThrow(()->new RuntimeException("Empry user")));

		userRepository.findAndSort("Pe", Sort.by("id").descending())
				.stream()
				.forEach(user->LOGGER.info("User sort:"+user.getName()));

		userRepository.findByName("Jhon")
				.stream()
				.forEach(user -> LOGGER.info("Usuario con query Method: "+user));

		LOGGER.info("Usuario con query method name - email:"+userRepository.findByNameAndEmail("Mario", "Mario@unillanos.edu.co").orElseThrow(()-> new RuntimeException("Not exits")));

		userRepository.findByNameLike("%Ma%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameLike: "+user));

		userRepository.findByNameOrEmail(null,"Leidy@unillanos.edu.co")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameOrEmail: "+user));

		userRepository.findByBirthDateBetween(LocalDate.of(2021,3, 20), LocalDate.of(2022,02, 01))
				.stream()
				.forEach(user -> LOGGER.info("Usario con intervalo de fechas: "+user));

		userRepository.findByNameLikeOrderByIdDesc("%Pe%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado: "+user));

		userRepository.findByNameContainingOrderByIdDesc("Pe")
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado con contain y ordenado: "+user));
	}
	private void saveUserInDataBase(){
		User user1 = new User("Jhon", "jhon.ochoa@unillanos.edu.co", LocalDate.of(2021, 03, 20));
		User user2 = new User("Vane", "vane.paredes@unillanos.edu.co", LocalDate.of(2021, 05, 21));
		User user3 = new User("Mario", "Mario@unillanos.edu.co", LocalDate.of(2021, 1, 21));
		User user4 = new User("Juan", "Juan@unillanos.edu.co", LocalDate.of(2021, 2, 21));
		User user5 = new User("Pedro", "Pedro@unillanos.edu.co", LocalDate.of(2021, 3, 21));
		User user6 = new User("Martha", "Martha@unillanos.edu.co", LocalDate.of(2021, 6, 21));
		User user7 = new User("Leidy", "Leidy@unillanos.edu.co", LocalDate.of(2021, 9, 21));
		User user8 = new User("Pepito", "Pepito@unillanos.edu.co", LocalDate.of(2021, 10, 21));
		User user9 = new User("Juanito", "Juanito@unillanos.edu.co", LocalDate.of(2021, 11, 21));
		User user10 = new User("Perenseno", "Perenseno@unillanos.edu.co", LocalDate.of(2021, 12, 21));

		List<User> users = Arrays.asList(user1,user2,user3,user4,user5, user6, user7, user8, user9, user10);
		users.stream().forEach(userRepository::save);

	}
	public void ejemploClasesAnteriores(){
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWithDepency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword());
		LOGGER.error("error--->");
	}
}
