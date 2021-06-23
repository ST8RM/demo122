package com.example.demo.controller.repository;

import com.example.demo.models.Host;
import org.springframework.data.repository.CrudRepository;


public interface HostRepository extends CrudRepository<Host,Long> {
}
