package com.ftninfowrmatika.jwd48.hardi.testback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Zadatak {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true, nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String zaduzeni;
	
	@Column
	private Integer bodovi;
	
	@ManyToOne
	private Sprint sprint;
	
	@ManyToOne
	private Stanje stanje;

	public Zadatak() {
	}

	public Zadatak(String ime, String zaduzeni, Integer bodovi, Sprint sprint, Stanje stanje) {
		this.ime = ime;
		this.zaduzeni = zaduzeni;
		this.bodovi = bodovi;
		this.sprint = sprint;
		this.stanje = stanje;
	}

	public Zadatak(Long id, String ime, String zaduzeni, Integer bodovi, Sprint sprint, Stanje stanje) {
		this.id = id;
		this.ime = ime;
		this.zaduzeni = zaduzeni;
		this.bodovi = bodovi;
		this.sprint = sprint;
		this.stanje = stanje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zadatak other = (Zadatak) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getZaduzeni() {
		return zaduzeni;
	}

	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}

	public Integer getBodovi() {
		return bodovi;
	}

	public void setBodovi(Integer bodovi) {
		this.bodovi = bodovi;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "Zadatak [id=" + id + ", ime=" + ime + ", zaduzeni=" + zaduzeni + ", bodovi=" + bodovi + ", sprint="
				+ sprint + ", stanje=" + stanje + "]";
	}
	
}
