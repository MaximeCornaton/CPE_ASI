/**
 * 
 */
package com.sp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
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

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * @author paulaubry
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {
	
	@Autowired
	UserRepository uRepo;
	
	User savedUser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		savedUser = uRepo.save(new User(1,"Paul","Aubry","pass",1000));
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
		User user = uRepo.save(new User("test1","testSurname1","testPassword1",2000));
		List<User> userList = new ArrayList<>();
		uRepo.findAll().forEach(userList::add);
		assertEquals(userList.size(), 1);
		assertEquals(userList.get(0).getId(),user.getId());
		assertEquals(userList.get(0).getName(),user.getName());
		assertEquals(userList.get(0).getSurname(),user.getSurname());
		assertEquals(userList.get(0).getPassword(),user.getPassword());
		assertEquals(userList.get(0).getMoney(),user.getMoney());
	}
	
	/**
	 * Test method for {@link com.sp.repository.UserRepository#findBySurname(java.lang.String)}.
	 */
	@Test
	final void testFindBySurname() {
		Optional<User> found = uRepo.findBySurname("Aubry");
		assertThat(found.isPresent()).isTrue();
		assertThat(found.get().getSurname()).isEqualTo("Aubry");

	}

	/**
	 * Test method for {@link com.sp.repository.UserRepository#findById(int)}.
	 */
	@Test
	final void testFindByIdInt() {
		Optional<User> found = uRepo.findById(savedUser.getId());
		assertThat(found.isPresent()).isTrue();
		assertThat(found.get().getId()).isEqualTo(savedUser.getId());
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#save(S)}.
	 */
	@Test
	final void testSave() {
	    User user = new User("test","testSurname","testPassword",1000);
	    uRepo.save(user);
	    Optional<User> found = uRepo.findBySurname(user.getSurname());
	    assertThat(found.isPresent()).isTrue();
	    assertThat(found.get()).usingRecursiveComparison().isEqualTo(user);
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#saveAll(java.lang.Iterable)}.
	 */
	@Test
	final void testSaveAll() {
	    List<User> users = new ArrayList<>();
	    users.add(new User(4,"test4","testSurname4","testPassword4",4000));
	    users.add(new User(5,"test5","testSurname5","testPassword5",5000));
	    uRepo.saveAll(users);
	    Iterable<User> found = uRepo.findAll();
	    assertThat(found).hasSize(3);
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findById(java.lang.Object)}.
	 */
	@Test
	final void testFindByIdID() {
	    Optional<User> found = uRepo.findById(savedUser.getId());
	    assertThat(found.isPresent()).isTrue();
	    assertThat(found.get().getId()).isEqualTo(savedUser.getId());
	    assertThat(found.get().getName()).isEqualTo(savedUser.getName());
	    assertThat(found.get().getSurname()).isEqualTo(savedUser.getSurname());
	    assertThat(found.get().getPassword()).isEqualTo(savedUser.getPassword());
	    assertThat(found.get().getMoney()).isEqualTo(savedUser.getMoney());
	 }

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#existsById(java.lang.Object)}.
	 */
	@Test
	final void testExistsById() {
	    User user = uRepo.save(new User("test6","testSurname6","testPassword6",6000));
	    boolean exists = uRepo.existsById(user.getId());
	    assertThat(exists).isTrue();
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findAll()}.
	 */
	@Test
	final void testFindAll() {
	    List<User> users = new ArrayList<>();
	    users.add(new User(7,"test7","testSurname7","testPassword7",7000));
	    users.add(new User(8,"test8","testSurname8","testPassword8",8000));
	    uRepo.saveAll(users);
	    Iterable<User> found = uRepo.findAll();
	    assertThat(found).hasSize(3);
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#findAllById(java.lang.Iterable)}.
	 */
	@Test
	final void testFindAllById() {
	    User user2 = uRepo.save(new User("test2", "testSurname2", "testPassword2", 2000));
	    List<Integer> ids = new ArrayList<>();
	    ids.add(savedUser.getId());
	    ids.add(user2.getId());
	    Iterable<User> users = uRepo.findAllById(ids);
	    List<User> userList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
	    assertThat(userList).hasSize(2);
	    assertThat(userList).extracting(User::getId).containsExactlyInAnyOrder(savedUser.getId(), user2.getId());
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#count()}.
	 */
	@Test
	final void testCount() {
	    List<User> users = new ArrayList<>();
	    users.add(new User(9,"test9","testSurname9","testPassword9",9000));
	    users.add(new User(10,"test10","testSurname10","testPassword10",10000));
	    uRepo.saveAll(users);
	    long count = uRepo.count();
	    assertThat(count).isEqualTo(3);
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)}.
	 */
	@Test
	final void testDeleteById() {
	    User user = uRepo.save(new User("test11","testSurname11","testPassword11",11000));
	    uRepo.save(user);
	    uRepo.deleteById(user.getId());
	    boolean exists = uRepo.existsById(user.getId());
	    assertThat(exists).isFalse();
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#delete(java.lang.Object)}.
	 */
	@Test
	final void testDelete() {
	    User user = new User(12,"test12","testSurname12","testPassword12",12000);
	    uRepo.save(user);
	    uRepo.delete(user);
	    boolean exists = uRepo.existsById(user.getId());
	    assertThat(exists).isFalse();
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteAllById(java.lang.Iterable)}.
	 */
	@Test
	final void testDeleteAllById() {
	    User user1 = uRepo.save(new User("test15","testSurname15","testPassword15",15000));
	    User user2 = uRepo.save(new User("test16","testSurname16","testPassword16",16000));
	    List<Integer> idsToDelete = new ArrayList<>();
	    idsToDelete.add(user1.getId());
	    idsToDelete.add(user2.getId());
	    uRepo.deleteAllById(idsToDelete);
	    boolean existsUser1 = uRepo.existsById(user1.getId());
	    boolean existsUser2 = uRepo.existsById(user2.getId());
	    assertThat(existsUser1).isFalse();
	    assertThat(existsUser2).isFalse();
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteAll(java.lang.Iterable)}.
	 */
	@Test
	final void testDeleteAllIterableOfQextendsT() {
	    User user1 = new User(17,"test17","testSurname17","testPassword17",17000);
	    User user2 = new User(18,"test18","testSurname18","testPassword18",18000);
	    uRepo.save(user1);
	    uRepo.save(user2);
	    List<User> usersToDelete = new ArrayList<>();
	    usersToDelete.add(user1);
	    usersToDelete.add(user2);
	    uRepo.deleteAll(usersToDelete);
	    boolean existsUser1 = uRepo.existsById(user1.getId());
	    boolean existsUser2 = uRepo.existsById(user2.getId());
	    assertThat(existsUser1).isFalse();
	    assertThat(existsUser2).isFalse();
	}

	/**
	 * Test method for {@link org.springframework.data.repository.CrudRepository#deleteAll()}.
	 */
	@Test
	final void testDeleteAll() {
	    List<User> users = new ArrayList<>();
	    users.add(new User(13,"test13","testSurname13","testPassword13",13000));
	    users.add(new User(14,"test14","testSurname14","testPassword14",14000));
	    uRepo.saveAll(users);
	    uRepo.deleteAll();
	    long count = uRepo.count();
	    assertThat(count).isEqualTo(0);
	}

}




