package com.veljkovracarevic.portfolio.controllers;

import com.veljkovracarevic.portfolio.dto.InfoDto;
import com.veljkovracarevic.portfolio.models.Info;
import com.veljkovracarevic.portfolio.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/portfolio/")
public class InfoController {

    private InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("info")
    public ResponseEntity<List<InfoDto>> getInfo(){
        return new ResponseEntity<>(infoService.getAllInfo(), HttpStatus.OK);
    }

    @GetMapping("info/{id}")
    public ResponseEntity<InfoDto> infoDetail(@PathVariable int id){
        return ResponseEntity.ok(infoService.getInfoById(id));
    }

    @PostMapping("info/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InfoDto> createInfo(@RequestBody InfoDto infoDto) {
        return new ResponseEntity<>(infoService.createInfo(infoDto), HttpStatus.CREATED);
    }

    @PutMapping("info/{id}/update")
    public ResponseEntity<InfoDto> updateInfo(@RequestBody InfoDto infoDto, @PathVariable("id") int infoId){
        InfoDto response = infoService.updateInfo(infoDto, infoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("info/{id}/delete")
    public ResponseEntity<String> deleteInfo(@PathVariable("id") int infoId){
        infoService.deleteInfoId(infoId);
        return new ResponseEntity<>("Info deleted.", HttpStatus.OK);
    }


}
