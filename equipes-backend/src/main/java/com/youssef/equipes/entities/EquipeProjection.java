package com.youssef.equipes.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomEquipe", types = { Equipe.class })
	public interface EquipeProjection {
		public String getNomEquipe();
		}

