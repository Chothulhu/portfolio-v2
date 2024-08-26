package com.veljkovracarevic.portfolio.service;

import com.veljkovracarevic.portfolio.dto.TechnologyDto;

import java.util.List;

public interface TechnologyService {
    TechnologyDto createTechnology (TechnologyDto techDto);

    List<TechnologyDto> getAllTechnologies();
    TechnologyDto getTechnologyById(int id);
    TechnologyDto updateTechnology(TechnologyDto techDto, int id);
    void deleteTechnology(int id);
}
