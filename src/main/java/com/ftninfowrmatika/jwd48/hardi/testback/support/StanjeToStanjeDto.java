package com.ftninfowrmatika.jwd48.hardi.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Stanje;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.StanjeDTO;

@Component
public class StanjeToStanjeDto implements Converter<Stanje, StanjeDTO> {

	@Override
	public StanjeDTO convert(Stanje source) {
		StanjeDTO dto = new StanjeDTO();
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		return dto;
	}

	public List<StanjeDTO> convert(List<Stanje> stanja){
		List<StanjeDTO> dto = new ArrayList<StanjeDTO>();
		for(Stanje s : stanja) {
			dto.add(convert(s));
		}
		return dto;
	}
}
