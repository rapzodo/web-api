package com.kingofus.auth.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingofus.LoginAuthApiApplication;
import com.kingofus.domain.LoginUser;
import org.hamcrest.core.StringContains;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoginAuthApiApplication.class)
@AutoConfigureMockMvc(secure = false)
public class LoginAuthControllerIntegrationTest {

    private static final String ROOT_URL = "/king-of-us/auth/api/v1";
    private static final String LOGIN_URL = ROOT_URL + "/login";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
//    @MockBean
//    private UsersManagementServiceImpl usersManagementService;

    @Test
    public void shouldLoginUserAndReturnLoggedUser() throws Exception {
        LoginUser loginUser = new LoginUser("johndoe@mail.com", "1234");
        mockMvc.perform(post(LOGIN_URL).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginUser)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(StringContains.containsString("\"lastLogin\"")));
    }

}
