package com.youssef.equipes.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor
@Entity
public class Ligue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigue;
	private String nomLigue;
	private String descriptionLigue;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ligue")
	private List<Equipe> equipes;
	
	 public Ligue() {
		 super();
	 }

	public Ligue( String nomLigue, String descriptionLigue, List<Equipe> equipes) {
		super();
		this.nomLigue = nomLigue;
		this.descriptionLigue = descriptionLigue;
		this.equipes = equipes;
	}
	public Long getIdLigue() {
		return idLigue;
	}
	public void setIdLigue(Long idLigue) {
		this.idLigue = idLigue;
	}
	public String getNomLigue() {
		return nomLigue;
	}
	public void setNomLigue(String nomLigue) {
		this.nomLigue = nomLigue;
	}
	public String getDescriptionLigue() {
		return descriptionLigue;
	}
	public void setDescriptionLigue(String descriptionLigue) {
		this.descriptionLigue = descriptionLigue;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	@Override
	public String toString() {
		return "Ligue [idLigue=" + idLigue + ", nomLigue=" + nomLigue + ", descriptionLigue=" + descriptionLigue
				+ ", equipes=" + equipes + "]";
	}
}
