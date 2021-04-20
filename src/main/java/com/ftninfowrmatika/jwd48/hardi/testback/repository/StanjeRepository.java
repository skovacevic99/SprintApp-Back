package com.ftninfowrmatika.jwd48.hardi.testback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Stanje;

@Repository
public interface StanjeRepository extends JpaRepository<Stanje, Long>{

	Stanje findOneById(Long id);
}
