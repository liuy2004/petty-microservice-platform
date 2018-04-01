package com.github.pettyfer.basic.basicinfoserver;

import com.alibaba.fastjson.JSONObject;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.github.pettyfer.basic.common.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PettyBasicInfoServerApplicationTests {

	@Autowired
	private ISystemUserService systemUserService;


	@Test
	public void contextLoads() {
		UserInfo userInfo = systemUserService.findUserInfoByUsername("admin");
	}

}
