package com.Autonation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email,String password);
	
	
}
