package com.ftninfowrmatika.jwd48.hardi.testback.service;

import java.util.List;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Stanje;

public interface StanjeService {

	List<Stanje> findAll();
	
	Stanje findOne(Long id);
	
	Stanje update(Stanje stanje);
}
