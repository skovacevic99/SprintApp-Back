package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Stanje;
import com.ftninfowrmatika.jwd48.hardi.testback.service.StanjeService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.StanjeToStanjeDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.StanjeDTO;

@RestController
@RequestMapping(value = "/api/stanja", produces = MediaType.APPLICATION_JSON_VALUE)
public class StanjeController {

	@Autowired
	private StanjeService stanjeService;
	
	@Autowired
	private StanjeToStanjeDto toDto;
	
	@GetMapping
	public ResponseEntity<List<StanjeDTO>> getAll(){
		
		List<Stanje> stanja = stanjeService.findAll();
		
		return new ResponseEntity<List<StanjeDTO>>(toDto.convert(stanja), HttpStatus.OK);
	}
}
