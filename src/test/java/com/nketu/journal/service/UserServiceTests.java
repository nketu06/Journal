package com.nketu.journal.service;

import com.nketu.journal.entity.User;
import com.nketu.journal.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFindByUserName(){
//        assertEquals(4,2+2);
//        assertTrue(5>=5);
        assertNotNull(userRepository.findByUserName("ketu"));

    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
            "1,2,4"
    })
    public void test_temp(int a , int b, int expected){
        assertEquals(expected,a+b);
    }

    @Test
    public void testSaveNewUser(){
        User test_user = new User();
        test_user.setUserName("TEST_NAME");
        test_user.setPassword(("PASS"));
        assertTrue(userService.saveNewUser(test_user));
    }

    @Test
    public void testDeleteByUserName(){
        assertTrue((userService.deleteByUserName("TEST_NAME")));
    }
}
