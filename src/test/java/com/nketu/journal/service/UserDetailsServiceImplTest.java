package com.nketu.journal.service;

import com.nketu.journal.entity.User;
import com.nketu.journal.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void  loadUserByUsernameTest(){
        User test_user = new User();
        test_user.setUserName("TEST_NAME");
        test_user.setPassword(("PASS"));
        test_user.setRoles(new ArrayList<>());
        when(userRepository.findByUserName(anyString())).thenReturn(test_user);
        UserDetails userDetails = userDetailsService.loadUserByUsername("ketu");
        Assertions.assertEquals("TEST_NAME",userDetails.getUsername());
    }
}
