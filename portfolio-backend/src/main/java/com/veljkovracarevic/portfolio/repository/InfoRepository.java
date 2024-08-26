package com.veljkovracarevic.portfolio.repository;

import com.veljkovracarevic.portfolio.models.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Integer> {
}
