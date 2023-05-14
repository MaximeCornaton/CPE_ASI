/**
 * 
 */
package com.sp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sp.model.User;

/**
 * @author paulaubry
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {
	
	@Autowired
	UserRepository uRepo;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		uRepo.save(new User(1,"Paul","Aubry","pass",1000));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void cleanUp() throws Exception {
		uRepo.deleteAll();
	}
	
	@Test
	void testSaveAndGet() {
		uRepo.deleteAll();
		uRepo.save(new User(2,"test1","testSurname1","testPassword1",2000));
		List<User> userList = new ArrayList<>();
		uRepo.findAll().forEach(userList::add);
		assertEquals(userList.size(), 1);
		assertEquals(userList.get(0).getId(),1);
		assertEquals(userList.get(0).getName(),"test1");
		assertEquals(userList.get(0).getSurname(),"testSurname1");
		assertEquals(userList.get(0).getPassword(),"testPAssword1");
		assertEquals(userList.get(0).getMoney(),2000);
	}
	
	/**
	 * Test method for {@link com.sp.repository.UserRepository#findBySurname(java.lang.String)}.
	 */
	@Test
	final void testFindBySurname() {
		uRepo.save(new User(2,"test1","testSurname1","testPassword1",2000));
		uRepo.save(new User(3,"test2","testSurname2","testPassword2",2000));
		uRepo.save(new User(4,"test2","testSurname2","testPassword2",2000));
		uRepo.save(new User(5,"test2","testSurname2","testPassword2",2000));
		List<User> userList = new ArrayList<>();
		uRepo.findBySurname("test2").forEach(userList::add);

	}

	/**
	 * Test method for {@link com.sp.repository.UserRepository#findById(int)}.
	 */
	@Test
	final void testFindByIdInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#save(S)}.
	 */
	@Test
	final void testSave() {
		uRepo.save(new User(1,"test","testSurname","testPassword",1000));
		assertTrue(true);
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#saveAll(java.lang.Iterable)}.
	 */
	@Test
	final void testSaveAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findById(java.lang.Object)}.
	 */
	@Test
	final void testFindByIdID() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#existsById(java.lang.Object)}.
	 */
	@Test
	final void testExistsById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findAll()}.
	 */
	@Test
	final void testFindAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findAllById(java.lang.Iterable)}.
	 */
	@Test
	final void testFindAllById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#count()}.
	 */
	@Test
	final void testCount() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)}.
	 */
	@Test
	final void testDeleteById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#delete(java.lang.Object)}.
	 */
	@Test
	final void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteAllById(java.lang.Iterable)}.
	 */
	@Test
	final void testDeleteAllById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteAll(java.lang.Iterable)}.
	 */
	@Test
	final void testDeleteAllIterableOfQextendsT() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteAll()}.
	 */
	@Test
	final void testDeleteAll() {
		fail("Not yet implemented"); // TODO
	}

}




