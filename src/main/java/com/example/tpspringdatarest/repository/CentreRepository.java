package com.example.tpspringdatarest.repository;

import com.example.tpspringdatarest.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CentreRepository extends JpaRepository<Centre, Long> {
}
