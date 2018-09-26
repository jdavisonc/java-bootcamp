package topic5.cartService;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@WebMvcTest
public class CartServiceImplTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetItems() throws Exception {
		this.mockMvc.perform(get("/items")).andExpect(status().isOk()).andExpect(content().json("[]"));
	}

	@Test
	public void testAddItem() throws Exception{
		this.mockMvc.perform(post("/items").content("{'name': 'apple' , 'price': 50, 'id': 2}")).andExpect(status().isOk());
	}

	@Test
	public void testEmptyCart() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

}
