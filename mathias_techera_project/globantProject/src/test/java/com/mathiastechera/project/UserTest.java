package com.mathiastechera.project;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathiastechera.project.user.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

//	private UserRepository repository;
//    private MockMvc mvc;
//    ObjectMapper mapper = new ObjectMapper();
//
//	String username = "bob";
//	String password = "pwdbob";
//	
//    @Before
//    public void loadUser() {
//		User newUserData = new User(username, password , "Bob", "Dylan" , "bob@mail.com");
//		repository.save(newUserData);
//    }
//	@Test
//	public void userLogin()		
//			  throws Exception {
//				User userLogin = new User(username, password , "Bob", "Dylan" , "bob@mail.com");
//									    			
//			     mvc.perform(post("/user/login")
//			      .contentType(MediaType.APPLICATION_JSON_UTF8)
//	              .content(mapper.writeValueAsString(userLogin)))
//	              .andExpect(status().isOk())
//	              .andExpect(jsonPath("$.username", is(username)));
//			}

}
