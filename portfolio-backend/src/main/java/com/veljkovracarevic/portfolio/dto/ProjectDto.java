package com.veljkovracarevic.portfolio.dto;

import lombok.Data;

@Data
public class ProjectDto {
    private int id;
    private String name;
    private String logoPath;
    private String link;
    private String description;
}
