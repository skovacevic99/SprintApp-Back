package com.ftninfowrmatika.jwd48.hardi.testback.service;

import java.util.List;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Sprint;

public interface SprintService {

	List<Sprint> findAll();
	
	Sprint findOne(Long id);
	
	Sprint update(Sprint sprint);
}
