package kasyan.springweb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    void startLogin() throws Exception {
        mockMvc.perform(get("/person/startlogin"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void startLoginPost() throws Exception {
        String login = "admin";
        String password = "password";

        mockMvc.perform(post("/person/startlogin")
                .param("login", login)
                .param("password", password))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void currentlogin() throws Exception {
        mockMvc.perform(get("/person/currentlogin"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void nocurrentlogin() throws Exception {
        mockMvc.perform(get("/person/nocurrentlogin"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}