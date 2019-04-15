package com.topicfive.UserService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

	User findByUsername(String name);
}
