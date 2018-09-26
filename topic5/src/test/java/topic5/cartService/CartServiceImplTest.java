package topic5.cartService;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
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
public class CartServiceImplTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetItems() throws Exception {
		this.mockMvc.perform(get("/items")).andExpect(status().isOk()).andExpect(content().json("[]"));
	}

	@Test
	public void testAddItem() throws Exception {
		this.mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"apple\",\"price\":50}"))
				.andExpect(status().isOk());
		this.mockMvc.perform(get("/items")).andExpect(status().isOk())
				.andExpect(jsonPath("$[*].name", hasItem("apple"))).andExpect(jsonPath("$[*].price", hasItem(50)));
		

	}

	@Test
	public void testEmptyCart() throws Exception {
		this.mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"apple\",\"price\":50}"))
				.andExpect(status().isOk());
		this.mockMvc.perform(delete("/items/empty")).andExpect(status().isOk());
		this.mockMvc.perform(get("/items")).andExpect(status().isOk()).andExpect(content().json("[]"));

	}

	@Test
	public void testPrice() throws Exception{
		this.mockMvc.perform(delete("/items/empty")).andExpect(status().isOk());
		this.mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"apple\",\"price\":50}"))
		.andExpect(status().isOk());
		this.mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"orange\",\"price\":150}"))
		.andExpect(status().isOk());
		
		MvcResult result = this.mockMvc.perform(get("/items")).andExpect(status().isOk()).andReturn();
		String resultAsString = result.getResponse().getContentAsString();
		
		JSONArray jsonArray = new JSONArray(resultAsString);
		int sum = 0;
		
		for(int i=0; i < jsonArray.length() ; i++ ) {
			JSONObject object = jsonArray.getJSONObject(i);
			sum += object.getInt("price");
		}
		assertTrue(sum == 200);
		
	}

	@Test
	public void testRemove() throws Exception {
		this.mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"apple\",\"price\":50}"))
		.andExpect(status().isOk());
		this.mockMvc.perform(delete("/items/{id}", 0)).andExpect(status().isOk());
		MvcResult result = this.mockMvc.perform(get("/items")).andExpect(status().isOk()).andReturn();
		
		String resultAsString = result.getResponse().getContentAsString();
		
		JSONArray jsonArray = new JSONArray(resultAsString);
		
		for(int i=0; i < jsonArray.length() ; i++ ) {
			JSONObject object = jsonArray.getJSONObject(i);
			if (object.getInt("id") == 0) {
				fail("Didnt delete the desired object");
			}
		}
		assertTrue(true);
		
	}

}
