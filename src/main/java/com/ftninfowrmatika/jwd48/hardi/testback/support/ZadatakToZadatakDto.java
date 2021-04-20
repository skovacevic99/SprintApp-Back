package com.ftninfowrmatika.jwd48.hardi.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Zadatak;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.ZadatakDTO;

@Component
public class ZadatakToZadatakDto implements Converter<Zadatak, ZadatakDTO> {

	@Override
	public ZadatakDTO convert(Zadatak source) {
		ZadatakDTO dto = new ZadatakDTO();
		dto.setBodovi(source.getBodovi());
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setSprintId(source.getSprint().getId());
		dto.setSprintIme(source.getSprint().getIme());
		dto.setStanjeId(source.getStanje().getId());
		dto.setStanjeIme(source.getStanje().getIme());
		dto.setZaduzeni(source.getZaduzeni());
		
		return dto;
	}
	
	public List<ZadatakDTO> convert(List<Zadatak> zadaci){
		List<ZadatakDTO> dto = new ArrayList<ZadatakDTO>();
		for(Zadatak z : zadaci) {
			dto.add(convert(z));
		}
		return dto;
	}

}
