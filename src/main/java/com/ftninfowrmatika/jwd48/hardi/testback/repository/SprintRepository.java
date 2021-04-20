package com.ftninfowrmatika.jwd48.hardi.testback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
	
	Sprint findOneById(Long id);

}
