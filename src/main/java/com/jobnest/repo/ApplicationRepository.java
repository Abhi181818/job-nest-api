package com.jobnest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobnest.dvo.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}