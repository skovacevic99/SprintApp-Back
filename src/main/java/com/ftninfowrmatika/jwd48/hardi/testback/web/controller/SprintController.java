package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Sprint;
import com.ftninfowrmatika.jwd48.hardi.testback.service.SprintService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.SprintToSprintDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.SprintDTO;

@RestController
@RequestMapping(value = "/api/sprintovi", produces = MediaType.APPLICATION_JSON_VALUE)
public class SprintController {
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private SprintToSprintDto toDto;
	
	@GetMapping
	public ResponseEntity<List<SprintDTO>> getAll(){
		
		List<Sprint> sprintovi = sprintService.findAll();
		
		return new ResponseEntity<List<SprintDTO>>(toDto.convert(sprintovi), HttpStatus.OK);
	}

}
