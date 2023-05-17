/**
 * 
 */
package com.sp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.User;

/**
 * @author paulaubry
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	
	Optional<User> findBySurname(String surname);

	Optional<User> findById(int id);
	
}
