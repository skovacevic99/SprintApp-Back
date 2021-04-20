package com.ftninfowrmatika.jwd48.hardi.testback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stanje {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String ime;
	
	@OneToMany(mappedBy = "stanje", cascade = CascadeType.ALL)
	private List<Zadatak> zadaci = new ArrayList<Zadatak>();

	public Stanje() {
	}

	public Stanje(String ime, List<Zadatak> zadaci) {
		this.ime = ime;
		this.zadaci = zadaci;
	}

	public Stanje(Long id, String ime, List<Zadatak> zadaci) {
		this.id = id;
		this.ime = ime;
		this.zadaci = zadaci;
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

	public List<Zadatak> getZadaci() {
		return zadaci;
	}

	public void setZadaci(List<Zadatak> zadaci) {
		this.zadaci = zadaci;
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
		Stanje other = (Stanje) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stanje [id=" + id + ", ime=" + ime + ", zadaci=" + zadaci + "]";
	}
	
	public void obrisiZadatak(Long id) {
		for(Zadatak z : this.zadaci) {
			if(z.getId() == id) {
				this.zadaci.remove(z);
				return;
			}
		}
	}
}
