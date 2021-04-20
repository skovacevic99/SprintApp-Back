package com.ftninfowrmatika.jwd48.hardi.testback.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Zadatak;

@Repository
public interface ZadatakRepository extends JpaRepository<Zadatak, Long>{
	
	Zadatak findOneById(Long id);

	@Query("SELECT z FROM Zadatak z WHERE " +
			"(:imeZadatka = NULL OR z.ime LIKE %:imeZadatka%) AND " +
			"(:sprintId = NULL OR z.sprint.id = :sprintId) " +
			"ORDER BY z.zaduzeni")
	Page<Zadatak> search(String imeZadatka, Long sprintId, Pageable pageable);

	@Query("SELECT COALESCE(SUM(z.bodovi), 0) FROM Zadatak z WHERE z.sprint.id = :sprintId")
	Long sum(Long sprintId);

}
