package com.ftninfowrmatika.jwd48.hardi.testback.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Zadatak;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.ZadatakDTO;

public interface ZadatakService {

	List<Zadatak> findAll();
	
	Zadatak findOne(Long id);

	Page<Zadatak> find(String imeZadatka, Long sprintId, int pageNo);
	
	Zadatak save(ZadatakDTO dto);
	
	Zadatak update(ZadatakDTO dto);
	
	Zadatak delete(Long id);

	Zadatak promeniStanje(Long id);

	Long sum(Long sprintId);
}
