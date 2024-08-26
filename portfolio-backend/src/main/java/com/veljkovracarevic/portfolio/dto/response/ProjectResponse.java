package com.veljkovracarevic.portfolio.dto.response;

import com.veljkovracarevic.portfolio.dto.ProjectDto;
import lombok.Data;

import java.util.List;

@Data
public class ProjectResponse {

    private List<ProjectDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
