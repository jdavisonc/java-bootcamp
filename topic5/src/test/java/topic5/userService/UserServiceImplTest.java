package topic5.userService;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserServiceImplTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateUser() throws Exception {
		// Add test user
		this.mockMvc
				.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"Flash\",\"nickName\":\"Gordon\",\"email\":\"f.gordon@gmail.com\"}"))
				.andExpect(status().isOk());
		// use get to check if its there
		this.mockMvc.perform(get("/user/userName/{userName}", "Flash")).andExpect(status().isOk());
	}

	@Test
	public void testDeleteUser() throws Exception {
		// Add a user
		this.mockMvc
				.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"Carmen\",\"nickName\":\"San Diego\",\"email\":\"san.diego@gmail.com\"}"))
				.andExpect(status().isOk());
		// Delete the user
		this.mockMvc.perform(delete("/user/{username}", "Carmen")).andExpect(status().isOk());
		// Check if its there
		this.mockMvc.perform(get("/user/userName/{userName}", "Carmen")).andExpect(status().isNotFound());
	}

	@Test
	public void testUpdateUserByUserName() throws Exception {
		// Add a user
		this.mockMvc
				.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"Mike\",\"nickName\":\"Tyson\",\"email\":\"m.tyson@gmail.com\"}"))
				.andExpect(status().isOk());
		MvcResult result = this.mockMvc
				.perform(post("/user/updateByUserName/{UserName}", "Mike").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"Mike\",\"nickName\":\"Tyson\",\"email\":\"tyson.m@gmail.com\"}"))
				.andExpect(status().isOk()).andReturn();

		String resultAsString = result.getResponse().getContentAsString();

		assertEquals("{\"userName\":\"Mike\",\"nickName\":\"Tyson\",\"email\":\"tyson.m@gmail.com\"}", resultAsString );

	}

	@Test
	public void testUpdateUserByNickName() throws Exception {
		// Add a user
		this.mockMvc
				.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"Frank\",\"nickName\":\"Sinatra\",\"email\":\"franSinatra@gmail.com\"}"))
				.andExpect(status().isOk());
		MvcResult result = this.mockMvc
				.perform(post("/user/updateByNickName/{nickname}", "Sinatra").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"Frank\",\"nickName\":\"Sinatra\",\"email\":\"f.sinatra@gmail.com\"}"))
				.andExpect(status().isOk()).andReturn();

		String resultAsString = result.getResponse().getContentAsString();

		assertEquals(resultAsString, "{\"userName\":\"Frank\",\"nickName\":\"Sinatra\",\"email\":\"f.sinatra@gmail.com\"}");

	}

	@Test
	public void testGetUserByNickName() throws Exception {
		// Get user by nickname
		this.mockMvc.perform(get("/user/nickName/{nickName}", "Schwarzenegger")).andExpect(status().isOk());
	}

	@Test
	public void testGetUserByUserName() throws Exception {
		// add user
		this.mockMvc
				.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"Arnold\",\"nickName\":\"Schwarzenegger\",\"email\":\"a.schwarzenegger@gmail.com\"}"))
				.andExpect(status().isOk());

		// get user by userName
		this.mockMvc.perform(get("/user/userName/{userName}", "Arnold")).andExpect(status().isOk());
	}

}
