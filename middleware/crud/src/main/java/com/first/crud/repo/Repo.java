package com.first.crud.repo;
import com.first.crud.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface Repo extends JpaRepository<User,Integer> {



}

