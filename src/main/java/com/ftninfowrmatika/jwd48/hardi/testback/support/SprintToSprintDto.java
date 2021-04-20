package com.ftninfowrmatika.jwd48.hardi.testback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Sprint;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.SprintDTO;

@Component
public class SprintToSprintDto implements Converter<Sprint, SprintDTO> {

	@Override
	public SprintDTO convert(Sprint source) {
		SprintDTO dto = new SprintDTO();
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setUkupnoBodova(source.getUkupnoBodova());
		return dto;
	}
	
	public List<SprintDTO> convert(List<Sprint> sprintovi){
		List<SprintDTO> dto = new ArrayList<SprintDTO>();
		for(Sprint sprint : sprintovi) {
			dto.add(convert(sprint));
		}
		return dto;
	}

}
