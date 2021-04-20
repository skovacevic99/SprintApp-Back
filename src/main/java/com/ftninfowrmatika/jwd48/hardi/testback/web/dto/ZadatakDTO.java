package com.ftninfowrmatika.jwd48.hardi.testback.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

public class ZadatakDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	@Min(value = 0, message = "Minimalno bodova je 0.")
	@Max(value = 20, message = "Maksimalano bodova je 20.")
	private Integer bodovi;
	
	@NonNull
	@NotBlank(message = "Ime zadatka ne moze biti prazno.")
	@Length(max = 40, message = "Duzina imena zadatka je maksimalno 40 karakter.")
	private String ime;
	
	private String zaduzeni;
	
	private Long sprintId;
	
	private String sprintIme;
	
	private Long stanjeId;
	
	private String stanjeIme;

	public ZadatakDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBodovi() {
		return bodovi;
	}

	public void setBodovi(Integer bodovi) {
		this.bodovi = bodovi;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZaduzeni() {
		return zaduzeni;
	}

	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}

	public Long getSprintId() {
		return sprintId;
	}

	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}

	public String getSprintIme() {
		return sprintIme;
	}

	public void setSprintIme(String sprintIme) {
		this.sprintIme = sprintIme;
	}

	public Long getStanjeId() {
		return stanjeId;
	}

	public void setStanjeId(Long stanjeId) {
		this.stanjeId = stanjeId;
	}

	public String getStanjeIme() {
		return stanjeIme;
	}

	public void setStanjeIme(String stanjeIme) {
		this.stanjeIme = stanjeIme;
	}
	
}
