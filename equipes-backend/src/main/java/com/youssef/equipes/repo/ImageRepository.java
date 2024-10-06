package com.youssef.equipes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youssef.equipes.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
} 