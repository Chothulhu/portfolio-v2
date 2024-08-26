package com.veljkovracarevic.portfolio.repository;

import com.veljkovracarevic.portfolio.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
