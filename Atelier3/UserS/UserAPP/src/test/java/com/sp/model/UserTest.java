/**
 * 
 */
package com.sp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author paulaubry
 *
 */
class UserTest {
	
	private User user;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("[Before test] --- Creating User for test");
		user = new User(1,"Paul","Aubry","pass",1000);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("[After Test] --- Cleaning User");
	}

	/**
	 * Test method for {@link com.sp.model.User#User()}.
	 */
	@Test
	void testUser() {
		User user = new User();
		assertNotNull(user);
	}

	/**
	 * Test method for {@link com.sp.model.User#User(int, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	void testUserIntStringStringStringInt() {
        assertEquals(1, user.getId());
        assertEquals("Paul", user.getName());
        assertEquals("Aubry", user.getSurname());
        assertEquals("pass", user.getPassword());
        assertEquals(1000, user.getMoney());
	}

	/**
	 * Test method for {@link com.sp.model.User#getId()}.
	 */
	@Test
	void testGetId() {
		assertEquals(1,user.getId());
	}

	/**
	 * Test method for {@link com.sp.model.User#setId(int)}.
	 */
	@Test
	void testSetId() {
		user.setId(2);
		assertEquals(2,user.getId());
	}

	/**
	 * Test method for {@link com.sp.model.User#getName()}.
	 */
	@Test
	void testGetName() {
		assertEquals("Paul",user.getName());
	}

	/**
	 * Test method for {@link com.sp.model.User#setName(java.lang.String)}.
	 */
	@Test
	void testSetName() {
		user.setName("Julien");
		assertEquals("Julien",user.getName());
	}

	/**
	 * Test method for {@link com.sp.model.User#getSurname()}.
	 */
	@Test
	void testGetSurname() {
		assertEquals("Aubry",user.getSurname());	
	}

	/**
	 * Test method for {@link com.sp.model.User#setSurname(java.lang.String)}.
	 */
	@Test
	void testSetSurname() {
		user.setSurname("Paulo");
		assertEquals("Paulo",user.getSurname());	
	}

	/**
	 * Test method for {@link com.sp.model.User#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		assertEquals("pass",user.getPassword());
	}

	/**
	 * Test method for {@link com.sp.model.User#setPassword(java.lang.String)}.
	 */
	@Test
	void testSetPassword() {
		user.setPassword("password");
		assertEquals("password",user.getPassword());
	}

	/**
	 * Test method for {@link com.sp.model.User#getMoney()}.
	 */
	@Test
	void testGetMoney() {
		assertEquals(1000,user.getMoney());
	}

	/**
	 * Test method for {@link com.sp.model.User#setMoney(int)}.
	 */
	@Test
	void testSetMoney() {
		user.setMoney(2000);
		assertEquals(2000,user.getMoney());
	}

	/**
	 * Test method for {@link com.sp.model.User#toString()}.
	 */
	@Test
	void testToString() {
	    String expected = "User [idUser=1, name=Paul, surname=Aubry, password=pass, money=1000]";
	    assertEquals(expected, user.toString());
	}

}
