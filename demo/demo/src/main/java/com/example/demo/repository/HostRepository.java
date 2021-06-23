package com.example.demo.controller.repository;

import com.example.demo.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HostRepository extends JpaRepository<Host,Long> {
}
