package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Sprint;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.SprintRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.SprintService;

@Service
public class JpaSprintService implements SprintService {

	@Autowired
	private SprintRepository sprintRepository;
	
	@Override
	public List<Sprint> findAll() {
		return sprintRepository.findAll();
	}

	@Override
	public Sprint findOne(Long id) {
		return sprintRepository.findOneById(id);
	}

	@Override
	public Sprint update(Sprint sprint) {
		return sprintRepository.save(sprint);
	}

}
