package com.github.pettyfer.basic.oauth;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@Suite.SuiteClasses({PasswordValidateTests.class,UserServiceTests.class})
public class PettyOAuth2ServiceApplicationTests {

}
