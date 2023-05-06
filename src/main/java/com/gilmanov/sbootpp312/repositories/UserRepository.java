package com.gilmanov.sbootpp312.repositories;

import com.gilmanov.sbootpp312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
