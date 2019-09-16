package com.wang.mongodemo.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class User {

    private Integer id;
    private String userName;
    private String description;
}
