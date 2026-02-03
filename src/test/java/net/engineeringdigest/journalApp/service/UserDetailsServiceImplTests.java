package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Service.UserDetailsServiceImpl;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest() {

        net.engineeringdigest.journalApp.entity.User entityUser =
                new net.engineeringdigest.journalApp.entity.User();

        entityUser.setUserName("Ram");
        entityUser.setPassword("sdfsdfsdfs");
        entityUser.setRoles(List.of("USER"));

        when(userRepository.findByUserName(anyString()))
                .thenReturn(entityUser);   // ✅ ENTITY USER

        UserDetails userDetails =
                userDetailsService.loadUserByUsername("Ram");

        Assertions.assertNotNull(userDetails);
    }
}
