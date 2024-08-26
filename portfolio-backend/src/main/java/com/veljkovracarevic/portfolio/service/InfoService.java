package com.veljkovracarevic.portfolio.service;

import com.veljkovracarevic.portfolio.dto.InfoDto;

import java.util.List;

public interface InfoService {
    InfoDto createInfo (InfoDto infoDto);

    List<InfoDto> getAllInfo();
    InfoDto getInfoById(int id);
    InfoDto updateInfo(InfoDto infoDto, int id);
    void deleteInfoId(int id);
}
