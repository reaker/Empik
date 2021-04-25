package com.example.empik.repository;

import com.example.empik.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	Login findByLogin(String login);

}
