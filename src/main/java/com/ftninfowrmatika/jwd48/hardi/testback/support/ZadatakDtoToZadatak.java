package com.ftninfowrmatika.jwd48.hardi.testback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Zadatak;
import com.ftninfowrmatika.jwd48.hardi.testback.service.SprintService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.StanjeService;
import com.ftninfowrmatika.jwd48.hardi.testback.service.ZadatakService;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.ZadatakDTO;

@Component
public class ZadatakDtoToZadatak implements Converter<ZadatakDTO, Zadatak> {

	@Autowired
	private ZadatakService zadatakService;
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private StanjeService stanjeService;
	
	@Override
	public Zadatak convert(ZadatakDTO dto) {
		Zadatak entity;
		
		if(dto.getId() == null) {
			entity = new Zadatak();
		} else {
			entity = zadatakService.findOne(dto.getId());
		}
		
		if(entity != null) {
			entity.setBodovi(dto.getBodovi());
			entity.setIme(dto.getIme());
			entity.setSprint(sprintService.findOne(dto.getSprintId()));
			entity.setStanje(stanjeService.findOne(dto.getStanjeId()));
			entity.setZaduzeni(dto.getZaduzeni());
			return entity;
		}
		return null;
	}

}
