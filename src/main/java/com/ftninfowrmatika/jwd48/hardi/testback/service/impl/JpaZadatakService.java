package com.ftninfowrmatika.jwd48.hardi.testback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Sprint;
import com.ftninfowrmatika.jwd48.hardi.testback.model.Stanje;
import com.ftninfowrmatika.jwd48.hardi.testback.model.Zadatak;
import com.ftninfowrmatika.jwd48.hardi.testback.repository.ZadatakRepository;
import com.ftninfowrmatika.jwd48.hardi.testback.service.SprintService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.StanjeService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.ZadatakService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.ZadatakDtoToZadatak;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.ZadatakDTO;

@Service
public class JpaZadatakService implements ZadatakService {

	@Autowired
	private ZadatakRepository zadatakRepository;
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private StanjeService stanjeService;
	
	@Autowired
	private ZadatakDtoToZadatak toZadatak;
	
	@Override
	public List<Zadatak> findAll() {
		return zadatakRepository.findAll();
	}

	@Override
	public Zadatak findOne(Long id) {
		return zadatakRepository.findOneById(id);
	}

	@Override
	public Page<Zadatak> find(String imeZadatka, Long sprintId, int pageNo) {
		return zadatakRepository.search(imeZadatka, sprintId, PageRequest.of(pageNo, 4));
	}

	@Override
	public Zadatak save(ZadatakDTO dto) {
		Zadatak zadatak = toZadatak.convert(dto);
		Sprint sprint = zadatak.getSprint();
		
		Integer bodovi = zadatak.getBodovi();
		sprint.setUkupnoBodova(String.valueOf(Integer.parseInt(sprint.getUkupnoBodova()) + bodovi));
		
		sprintService.update(sprint);
		Zadatak dodat = zadatakRepository.save(zadatak);
		if(dodat != null) {
			return dodat;
		}
		return null;
	}

	@Override
	public Zadatak update(ZadatakDTO dto) {
		Zadatak stariZadatak = zadatakRepository.findOneById(dto.getId());
		Integer stariBodovi = stariZadatak.getBodovi();
		
		Zadatak zadatak = toZadatak.convert(dto);
		if(zadatak != null) {
			Integer noviBodovi = zadatak.getBodovi();
			
			Sprint sprint = zadatak.getSprint();
			sprint.setUkupnoBodova(String.valueOf(Integer.parseInt(sprint.getUkupnoBodova()) - stariBodovi + noviBodovi));
			
			sprintService.update(sprint);
			zadatakRepository.save(zadatak);
			
			return zadatak;
		}
		return null;
	}

	@Override
	public Zadatak delete(Long id) {
		Zadatak zadatak = zadatakRepository.findOneById(id);
		if(zadatak != null) {
			Integer bodovi = zadatak.getBodovi();
			
			Sprint sprint = zadatak.getSprint();
			sprint.setUkupnoBodova(String.valueOf(Integer.parseInt(sprint.getUkupnoBodova()) - bodovi));
			
			Stanje stanje = zadatak.getStanje();
			stanje.obrisiZadatak(id);

			sprint.obrisiZadatak(id);
			
			stanjeService.update(stanje);
			sprintService.update(sprint);
			zadatakRepository.deleteById(id);
			
			return zadatak;
		}
		return null;
	}

	@Override
	public Zadatak promeniStanje(Long id) {
		Zadatak zadatak = zadatakRepository.findOneById(id);
		
		if(zadatak.getStanje().getId() == 1) {
			zadatak.setStanje(stanjeService.findOne(2L));
		} else if(zadatak.getStanje().getId() == 2) {
			zadatak.setStanje(stanjeService.findOne(3L));
		}
		
		Zadatak izmenje = zadatakRepository.save(zadatak);
		return izmenje;
	}

	@Override
	public Long sum(Long sprintId) {
		Long sum = zadatakRepository.sum(sprintId);
		System.out.println("********** SUM: " + sum);
		return sum;
	}

}
