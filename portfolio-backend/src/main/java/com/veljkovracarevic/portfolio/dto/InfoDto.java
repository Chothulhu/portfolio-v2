package com.veljkovracarevic.portfolio.dto;

import lombok.Data;

@Data
public class InfoDto {
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String picturePath;
    private String mail;
    private String phoneNumber;
    private String linkedIn;
    private String github;
}
