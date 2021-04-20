package com.ftninfowrmatika.jwd48.hardi.testback.web.dto;

import javax.validation.constraints.Positive;

public class SprintDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private String ime;
	
	private String ukupnoBodova;

	public SprintDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getUkupnoBodova() {
		return ukupnoBodova;
	}

	public void setUkupnoBodova(String ukupnoBodova) {
		this.ukupnoBodova = ukupnoBodova;
	}
	
}
