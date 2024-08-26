package com.veljkovracarevic.portfolio.controllers;

import com.veljkovracarevic.portfolio.dto.InfoDto;
import com.veljkovracarevic.portfolio.dto.TechnologyDto;
import com.veljkovracarevic.portfolio.service.InfoService;
import com.veljkovracarevic.portfolio.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio/")
public class TechnologyController {
    private TechnologyService techService;

    @Autowired
    public TechnologyController(TechnologyService techService) {
        this.techService = techService;
    }

    @GetMapping("tech")
    public ResponseEntity<List<TechnologyDto>> getAllTechnologies(){
        return new ResponseEntity<>(techService.getAllTechnologies(), HttpStatus.OK);
    }

    @GetMapping("tech/{id}")
    public ResponseEntity<TechnologyDto> techDetail(@PathVariable int id){
        return ResponseEntity.ok(techService.getTechnologyById(id));
    }

    @PostMapping("tech/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TechnologyDto> createTechnology(@RequestBody TechnologyDto techDto) {
        return new ResponseEntity<>(techService.createTechnology(techDto), HttpStatus.CREATED);
    }

    @PutMapping("tech/{id}/update")
    public ResponseEntity<TechnologyDto> updateTechnology(@RequestBody TechnologyDto techDto, @PathVariable("id") int techId){
        TechnologyDto response = techService.updateTechnology(techDto, techId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("tech/{id}/delete")
    public ResponseEntity<String> deleteTechnology(@PathVariable("id") int techId){
        techService.deleteTechnology(techId);
        return new ResponseEntity<>("Technology deleted.", HttpStatus.OK);
    }
}
