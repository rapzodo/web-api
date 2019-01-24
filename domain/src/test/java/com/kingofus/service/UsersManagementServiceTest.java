package com.kingofus.service;

import com.kingofus.persistence.entities.User;
import com.kingofus.persistence.repositories.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UsersManagementServiceTest {

    private UsersManagementService service;
    private UsersRepository repository;

    @Before
    public void setup() {
        repository = Mockito.mock(UsersRepository.class);
        service = new UsersManagementServiceImpl(repository);
    }

    @Test
    public void shouldCreateNewUser() {
        service.save(new User());
        verify(repository, only()).save(ArgumentMatchers.any(User.class));
    }

    @Test
    public void shouldFindByEmail() {
        when(repository.findUserByEmail(anyString())).thenReturn(Optional.of(new User()));
        assertThat(service.findByUserName("johnDoe")).isPresent();
        verify(repository, only()).findUserByEmail(anyString());
    }

    @Test
    public void shouldFindById() {
        service.findOne(anyLong());
        verify(repository, only()).findById(anyLong());
    }

    @Test
    public void findAllUsers() {
        service.getAll();
        verify(repository, only()).findAll();
    }
}