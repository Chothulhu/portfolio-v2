package com.veljkovracarevic.portfolio.repository;

import com.veljkovracarevic.portfolio.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
