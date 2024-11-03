	package com.youssef.equipes.entities;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomEquipe;
	
	@Min(value = 1)
	@Max(value = 1000)
	private int rankEquipe;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Ligue ligue;
	
	@OneToMany (mappedBy = "equipe")
	private List<Image> images;
	
	private String imagePath;
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/*
	@OneToOne
	private Image image;
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}*/
	public void addImage(Image image) {
        images.add(image);
        image.setEquipe(this);}
    
	public Ligue getLigue() {
		return ligue;
	}

	public void setLigue(Ligue ligue) {
		this.ligue = ligue;
	}

	public Equipe() {
		super();
		}
	
	public Equipe(String nomEquipe, int rankEquipe, Date dateCreation) {
		super();
		this.nomEquipe = nomEquipe;
		this.rankEquipe = rankEquipe;
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", rankEquipe=" + rankEquipe
				+ ", dateCreation=" + dateCreation + ", ligue=" + ligue + "]";
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public int getRankEquipe() {
		return rankEquipe;
	}
	public void setRankEquipe(int rankEquipe) {
		this.rankEquipe = rankEquipe;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	

}
