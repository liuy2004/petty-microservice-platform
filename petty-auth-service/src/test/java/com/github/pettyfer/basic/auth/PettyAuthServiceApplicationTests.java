package com.github.pettyfer.basic.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PettyAuthServiceApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(new BCryptPasswordEncoder().matches("admin","$2a$10$ruJZU6MaoqoTGstpiBs5P.y3OIs0f3H01iyf31qZz1NnS/BxrHMOa"));
	}

}
