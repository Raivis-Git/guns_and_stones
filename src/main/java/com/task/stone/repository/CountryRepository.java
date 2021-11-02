package com.task.stone.repository;

import com.task.stone.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
	
	Optional<Country> findByName(String name);
	
}
