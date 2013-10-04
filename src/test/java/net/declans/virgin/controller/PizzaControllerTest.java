package net.declans.virgin.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Date: 30/09/2013
 *
 * @author Declan Newman (declan)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:/spring/servlet-context.xml", "classpath:/spring/root-context.xml"})
public class PizzaControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void testSavePizzaDetails() throws Exception {
        this.mockMvc.perform(post("/pizza/save").param("pizzaSizeId", "1").param("toppingIds", new String[]{"1", "3"})
                .accept(MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andExpect(content().contentType("application/json")).andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("toppings[0].description").value("Pepperoni"));
    }

    @Test
    public void testPostPizzaDetails() throws Exception {
        this.mockMvc.perform(post("/pizza/update").param("pizzaSizeId", "1").param("toppingIds", new String[]{"1", "3"})
                .accept(MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("id").doesNotExist())
                .andExpect(jsonPath("toppings[1].description").value("Ham"));
    }

    @Test
    public void testPostPizzaToppings() throws Exception {
        this.mockMvc.perform(get("/pizza/toppings/4").accept(MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andExpect(content().contentType("application/json")).andExpect(
                jsonPath("[14].id").value(15));
    }

}
