package com.kingofus.management;

import com.kingofus.domain.UserAccount;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerIntegrationTest extends AbstractApisIntegrationTest{

    private static final String ROOT_URL = "/king-of-us/management/api/v1/users";
    private static final String FIND_BY_USERNAME_URL = ROOT_URL + "/search";

    @Test
    public void shouldCallApiAndSearchByEmail() throws Exception {
        mockMvc.perform(get(FIND_BY_USERNAME_URL)
                .param("email", "johndoe@mail.com"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(Matchers.containsString("\"email\" : \"johndoe@mail.com\"")));
    }

    @Test
    public void shouldCallApiAndBringAllUserAccounts() throws Exception {
        mockMvc.perform(get(ROOT_URL))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andDo(mvcResult ->
                        {
                            List result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
                            assertThat(result).hasSize(1);
                        }
                );
    }

    @Test
    public void shouldCallApiAndCreateNewUser() throws Exception {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("user@mail.com");
        userAccount.setFullName("John Doe");
        userAccount.setPassword("1234");
        userAccount.setBirthDate(LocalDate.of(1981, 3, 18));
        mockMvc.perform(post(ROOT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userAccount)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
