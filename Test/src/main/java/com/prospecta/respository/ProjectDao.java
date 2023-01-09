package com.prospecta.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospecta.model.Project;

public interface ProjectDao extends JpaRepository<Project, Integer>{
	
}
