package com.veljkovracarevic.portfolio.service;

import com.veljkovracarevic.portfolio.dto.ProjectDto;
import com.veljkovracarevic.portfolio.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);

    ProjectResponse getAllProjects(int pageNo, int pageSize);
    ProjectDto getProjectById(int id);
    ProjectDto updateProject(ProjectDto projectDto, int id);
    void deleteProjectId(int id);
}
