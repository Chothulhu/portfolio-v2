package com.veljkovracarevic.portfolio.service.impl;

import com.veljkovracarevic.portfolio.dto.InfoDto;
import com.veljkovracarevic.portfolio.exceptions.InfoNotFoundException;
import com.veljkovracarevic.portfolio.models.Info;
import com.veljkovracarevic.portfolio.repository.InfoRepository;
import com.veljkovracarevic.portfolio.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfoServiceImpl implements InfoService {

    private InfoRepository infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    public InfoDto createInfo(InfoDto infoDto) {
        Info info = new Info();
        info.setFirstName("Veljko");
        info.setLastName("Vračarević 2");
        info.setTitle("Software Developer");
        info.setPicturePath("pic-path");
        info.setMail("veljko.vracarevic@pmf.edu.rs");
        info.setPhoneNumber("+381 61-2021852");
        info.setLinkedIn("linked-in");
        info.setGithub("git-hub");

        Info newInfo = infoRepository.save(info);

        InfoDto infoResponse = new InfoDto();
        infoResponse.setId(newInfo.getId());
        infoResponse.setFirstName(newInfo.getFirstName());
        infoResponse.setLastName(newInfo.getLastName());
        return infoResponse;
    }

    @Override
    public List<InfoDto> getAllInfo() {
        List<Info> info = infoRepository.findAll();
        return  info.stream().map(inf -> mapToDto(inf)).collect(Collectors.toList());
    }

    @Override
    public InfoDto getInfoById(int id) {
        Info info = infoRepository.findById(id).orElseThrow(() -> new InfoNotFoundException("Info not found!"));
        return mapToDto(info);
    }

    @Override
    public InfoDto updateInfo(InfoDto infoDto, int id) {
        Info info = infoRepository.findById(id).orElseThrow( () -> new InfoNotFoundException("Info could not be updated!"));

        info.setFirstName(infoDto.getFirstName());
        info.setLastName(infoDto.getLastName());
        info.setTitle(infoDto.getTitle());
        info.setPicturePath(infoDto.getPicturePath());
        info.setMail(infoDto.getMail());
        info.setPhoneNumber(infoDto.getPhoneNumber());
        info.setLinkedIn(infoDto.getLinkedIn());
        info.setGithub(infoDto.getGithub());

        Info updatedInfo = infoRepository.save(info);
        return mapToDto(updatedInfo);
    }

    @Override
    public void deleteInfoId(int id) {
        Info info = infoRepository.findById(id).orElseThrow(() -> new InfoNotFoundException("Info could not be deleted!"));
        infoRepository.delete(info);
    }

    private InfoDto mapToDto(Info info){
        InfoDto infoDto = new InfoDto();

        infoDto.setId(info.getId());
        infoDto.setFirstName(info.getFirstName());
        infoDto.setLastName(info.getLastName());
        infoDto.setTitle(info.getTitle());
        infoDto.setPicturePath(info.getPicturePath());
        infoDto.setMail(info.getMail());
        infoDto.setPhoneNumber(info.getPhoneNumber());
        infoDto.setLinkedIn(info.getLinkedIn());
        infoDto.setGithub(info.getGithub());

        return infoDto;
    }

    private Info mapToEntity(InfoDto infoDto){
        Info info = new Info();

        info.setId(infoDto.getId());
        info.setFirstName(infoDto.getFirstName());
        info.setLastName(infoDto.getLastName());
        info.setTitle(infoDto.getTitle());
        info.setPicturePath(infoDto.getPicturePath());
        info.setMail(infoDto.getMail());
        info.setPhoneNumber(infoDto.getPhoneNumber());
        info.setLinkedIn(infoDto.getLinkedIn());
        info.setGithub(infoDto.getGithub());

        return info;
    }
}
