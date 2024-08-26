package com.veljkovracarevic.portfolio.controllers;

import com.veljkovracarevic.portfolio.dto.ProjectDto;
import com.veljkovracarevic.portfolio.dto.TechnologyDto;
import com.veljkovracarevic.portfolio.dto.response.ProjectResponse;
import com.veljkovracarevic.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio/")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("project")
    public ResponseEntity<ProjectResponse> getAllProjects(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        return new ResponseEntity<>(projectService.getAllProjects(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("project/{id}")
    public ResponseEntity<ProjectDto> projectDetail(@PathVariable int id){
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PostMapping("project/create")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(projectService.createProject(projectDto), HttpStatus.CREATED);
    }

    @PutMapping("project/{id}/update")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") int projectId){
        ProjectDto response = projectService.updateProject(projectDto, projectId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("project/{id}/delete")
    public ResponseEntity<String> deleteProject(@PathVariable("id") int projectId){
        projectService.deleteProjectId(projectId);
        return new ResponseEntity<>("Project deleted.", HttpStatus.OK);
    }

}
