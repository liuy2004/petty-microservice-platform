package com.github.pettyfer.basic.oauth;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2RequestTests {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Test
    public void passwordMode(){
        String url = "http://127.0.0.1:6060/oauth/token?username=admin&password=admin&grant_type=password&client_id=demo&client_secret=demoSecret";
        HttpHeaders httpHeaders = new HttpHeaders();
        Object object = restTemplate().exchange(url, HttpMethod.POST, new HttpEntity<>(httpHeaders),Object.class);
        System.out.println(JSONObject.toJSON(object));
    }

}
