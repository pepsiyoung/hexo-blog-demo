package com.pepsiyoung.web2.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {

    private String name;

    private LocalDateTime birthday;
}
