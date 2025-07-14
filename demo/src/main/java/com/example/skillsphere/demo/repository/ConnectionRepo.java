package com.example.skillsphere.demo.repository;

import com.example.skillsphere.demo.Entity.ConnectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepo extends JpaRepository<ConnectionRequest,Long> {
}
