/**
 * 
 */
package com.sp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sp.model.User;
import com.sp.repository.UserRepository;

/**
 * @author paulaubry
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserService.class)
class UserServiceTest {
	
	@MockBean
	private UserRepository uRepo;
	
	@Autowired
	private UserService userService;
	
	User tmpUser = new User(1,"Paul","Aubry","password",2000);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
        Mockito.when(uRepo.findById(1)).thenReturn(Optional.of(tmpUser));
        Mockito.when(uRepo.findBySurname("Aubry")).thenReturn(Optional.of(tmpUser));
        Mockito.when(uRepo.save(tmpUser)).thenReturn(tmpUser);
	}

	/**
	 * Test method for {@link com.sp.service.UserService#addUser(com.sp.model.User)}.
	 */
	@Test
	final void testAddUser() {
        userService.addUser(tmpUser);
        Mockito.verify(uRepo, Mockito.times(1)).save(tmpUser);
	}

	/**
	 * Test method for {@link com.sp.service.UserService#updateUser(com.sp.model.User)}.
	 */
	@Test
	final void testUpdateUser() {
        User updatedUser = userService.updateUser(tmpUser);
        assertEquals(tmpUser, updatedUser);
        Mockito.verify(uRepo, Mockito.times(1)).save(tmpUser);
	}

	/**
	 * Test method for {@link com.sp.service.UserService#getUser(java.lang.String)}.
	 */
	@Test
	final void testGetUserString() {
        User result = userService.getUser("Aubry");
        assertEquals(tmpUser, result);
	}

	/**
	 * Test method for {@link com.sp.service.UserService#getUser(int)}.
	 */
	@Test
	final void testGetUserInt() {
        User result = userService.getUser(1);
        assertEquals(tmpUser, result);
	}

}
