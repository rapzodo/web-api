package com.kingofus.service;

import com.kingofus.exceptions.InvalidCredentialsException;
import com.kingofus.persistence.entities.User;
import com.kingofus.persistence.repositories.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class DefaultLoginServiceTest {

    private LoginService service;
    private UsersRepository repository;

    @Before
    public void setup() {
        repository = Mockito.mock(UsersRepository.class);
        service = new DefaultLoginService(repository);
    }

    @Test
    public void shouldFindReturnUserFoundByEmailAndPassword() {
        when(repository.findUserByEmailAndPassword(ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(anUser()));
        final User loggedUser = service.login(anyString(), anyString());
        verify(repository, only()).findUserByEmailAndPassword(anyString(),anyString());
        assertThat(loggedUser.getEmail()).isNotNull();
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenUserNotFound(){
        doThrow(InvalidCredentialsException.class)
                .when(repository).findUserByEmailAndPassword("invalidEmail","invalidPassword");
        service.login("123", "123");
    }

    private User anUser() {
        return User.builder()
                .email("johndoe@mail.com")
                .password("123").build();
    }

}