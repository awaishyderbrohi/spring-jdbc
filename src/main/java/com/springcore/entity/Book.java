package com.springcore.entity;


import lombok.*;

@Data
@Builder
@ToString
public class Book {
    private long id;
    private String title;
    private String description;
    private String author;

}
