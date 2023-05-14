/**
 * 
 */
package com.sp.repository;

import static org.junit.jupiter.api.Assertions.*;

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

	/**
	 * Test method for {@link com.sp.repository.UserRepository#findBySurname(java.lang.String)}.
	 */
	@Test
	void testFindBySurname() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.sp.repository.UserRepository#findById(int)}.
	 */
	@Test
	void testFindByIdInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#save(S)}.
	 */
	@Test
	void testSave() {
		fail("Not yet implemented");
	}

}
