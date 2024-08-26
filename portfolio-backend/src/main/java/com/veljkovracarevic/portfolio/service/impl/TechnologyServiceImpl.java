package com.veljkovracarevic.portfolio.service.impl;

import com.veljkovracarevic.portfolio.dto.TechnologyDto;
import com.veljkovracarevic.portfolio.exceptions.InfoNotFoundException;
import com.veljkovracarevic.portfolio.exceptions.ProjectNotFoundException;
import com.veljkovracarevic.portfolio.exceptions.TechnologyNotFoundException;
import com.veljkovracarevic.portfolio.models.Technology;
import com.veljkovracarevic.portfolio.repository.TechnologyRepository;
import com.veljkovracarevic.portfolio.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    private TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public TechnologyDto createTechnology(TechnologyDto techDto) {
        Technology tech = new Technology();

        tech.setName("C#");
        tech.setPicturePath("placeholder-path");

        Technology newTech = technologyRepository.save(tech);

        TechnologyDto techResponse = new TechnologyDto();
        techResponse.setId(newTech.getId());
        techResponse.setName(newTech.getName());
        techResponse.setPicturePath(newTech.getPicturePath());
        return techResponse;
    }

    @Override
    public List<TechnologyDto> getAllTechnologies() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologies.stream().map(tech -> mapToDto(tech)).collect(Collectors.toList());
    }

    @Override
    public TechnologyDto getTechnologyById(int id) {
        Technology tech = technologyRepository.findById(id).orElseThrow(() -> new TechnologyNotFoundException("Technology not found!"));
        return mapToDto(tech);
    }

    @Override
    public TechnologyDto updateTechnology(TechnologyDto techDto, int id) {
        Technology tech = technologyRepository.findById(id).orElseThrow(() -> new TechnologyNotFoundException("Technology not found!"));

        tech.setName(techDto.getName());
        tech.setPicturePath(techDto.getPicturePath());

        Technology updateTech = technologyRepository.save(tech);
        return mapToDto(updateTech);
    }

    @Override
    public void deleteTechnology(int id) {
        Technology tech = technologyRepository.findById(id).orElseThrow(() -> new InfoNotFoundException("Technology could not be deleted!"));
        technologyRepository.delete(tech);
    }

    private TechnologyDto mapToDto(Technology tech){
        TechnologyDto techDto = new TechnologyDto();

        techDto.setId(tech.getId());
        techDto.setName(tech.getName());
        techDto.setPicturePath(tech.getPicturePath());
        return techDto;
    }

    private Technology mapToEntity(TechnologyDto techDto){
        Technology tech = new Technology();

        tech.setId(techDto.getId());
        tech.setName(techDto.getName());
        tech.setPicturePath(techDto.getPicturePath());

        return tech;
    }


}
