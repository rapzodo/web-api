package com.kingofus.domain.domain;

import com.kingofus.domain.LoggedUser;
import com.kingofus.domain.UserAccount;
import com.kingofus.domain.mapping.OrikaBeansMapper;
import com.kingofus.persistence.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrikaBeansMapper.class)
public class OrikaBeansMapperTest {

    @Autowired
    private OrikaBeansMapper orikaBeansMapper;

    @Test
    public void shouldMapUserToUserAccount() {
        User user = aUser();
        UserAccount userAccount = orikaBeansMapper.mapUserToUserAccount(user);

        assertThat(userAccount.getEmail()).isEqualTo(user.getEmail());
        assertThat(userAccount.getFullName()).isEqualTo("John Doe");
        assertThat(userAccount.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void shouldMapUserAccountToUser() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("userAccount@mail.com");
        userAccount.setFullName("John Doe");
        userAccount.setBirthDate(LocalDate.of(1981,3,18));
        userAccount.setLastLogin(LocalDateTime.of(2019,1,7, 1,0));
        userAccount.setPassword("1234");
        User u = orikaBeansMapper.mapUserAccountToUser(userAccount);

        assertThat(u.getEmail()).isEqualTo(userAccount.getEmail());
        assertThat(u.getFirstName()).isEqualTo("John");
        assertThat(u.getLastName()).isEqualTo("Doe");
        assertThat(u.getPassword()).isEqualTo(userAccount.getPassword());
    }

    @Test
    public void shouldMapUserToLoggedUser(){
        User user = aUser();
        LoggedUser loggedUser = orikaBeansMapper.map(user, LoggedUser.class);

        assertThat(loggedUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(loggedUser.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(loggedUser.getLastName()).isEqualTo(user.getLastName());
        assertThat(loggedUser.getLastLogin()).isEqualTo(user.getLastLogin());
    }

    private User aUser() {
        User user = new User();
        user.setEmail("user@mail.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setBirthDate(LocalDate.of(1981, 3, 18));
        user.setLastLogin(LocalDateTime.of(2019, 1, 7, 1, 0));
        user.setPassword("1234");
        return user;
    }

}