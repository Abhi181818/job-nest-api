package com.jobnest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobnest.dvo.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}