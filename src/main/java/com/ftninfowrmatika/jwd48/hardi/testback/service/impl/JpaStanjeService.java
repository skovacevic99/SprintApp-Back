package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Stanje;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.StanjeRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.StanjeService;

@Service
public class JpaStanjeService implements StanjeService {

	@Autowired
	private StanjeRepository stanjeRepository;
	
	@Override
	public List<Stanje> findAll() {
		return stanjeRepository.findAll();
	}

	@Override
	public Stanje findOne(Long id) {
		return stanjeRepository.findOneById(id);
	}

	@Override
	public Stanje update(Stanje stanje) {
		return stanjeRepository.save(stanje);
	}

}
