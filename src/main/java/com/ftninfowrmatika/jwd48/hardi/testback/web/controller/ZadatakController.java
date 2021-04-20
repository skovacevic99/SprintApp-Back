package com.ftninfowrmatika.jwd48.hardi.testback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninfowrmatika.jwd48.hardi.testback.model.Zadatak;
import com.ftninfowrmatika.jwd48.hardi.testback.service.ZadatakService;
import com.ftninfowrmatika.jwd48.hardi.testback.support.ZadatakToZadatakDto;
import com.ftninfowrmatika.jwd48.hardi.testback.web.dto.ZadatakDTO;

@RestController
@RequestMapping(value = "/api/zadaci", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZadatakController {

	@Autowired
	private ZadatakService zadatakService;
	
	@Autowired
	private ZadatakToZadatakDto toDto;
	
	@GetMapping
	public ResponseEntity<List<ZadatakDTO>> getAll(
			@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,
			@RequestParam(required = false) String imeZadatka,
			@RequestParam(required = false) Long sprintId
			){
		
		Page<Zadatak> zadaci = zadatakService.find(imeZadatka, sprintId, pageNo);
		
		Long sum = 0L;
		if(sprintId != null) {
			sum = zadatakService.sum(sprintId);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", String.valueOf(zadaci.getTotalPages()));
		
		if(sum != 0L) {
			headers.add("Sprint-Sum", String.valueOf(sum));
		}
		
		return new ResponseEntity<List<ZadatakDTO>>(toDto.convert(zadaci.getContent()), headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ZadatakDTO> getOne(@PathVariable Long id){
		
		Zadatak zadatak = zadatakService.findOne(id);
		
		return new ResponseEntity<ZadatakDTO>(toDto.convert(zadatak), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZadatakDTO> create(@Valid @RequestBody ZadatakDTO dto){
		
		Zadatak zadatak = zadatakService.save(dto);
		
		return new ResponseEntity<ZadatakDTO>(toDto.convert(zadatak), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZadatakDTO> update(@Valid @RequestBody ZadatakDTO dto, @PathVariable Long id){
		
		if(dto.getId() != id) {
			return new ResponseEntity<ZadatakDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Zadatak imenjen = zadatakService.update(dto);
		
		return new ResponseEntity<ZadatakDTO>(toDto.convert(imenjen), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		Zadatak obrisan = zadatakService.delete(id);
		
		if(obrisan != null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}/action")
	public ResponseEntity<ZadatakDTO> actionUpdate(@PathVariable Long id){
		
		Zadatak zadatak = zadatakService.promeniStanje(id);
		
		return new ResponseEntity<ZadatakDTO>(toDto.convert(zadatak), HttpStatus.OK);
	}
		
}
