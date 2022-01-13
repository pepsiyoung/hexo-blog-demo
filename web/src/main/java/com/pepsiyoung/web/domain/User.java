package com.pepsiyoung.web.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {

    @Max(10)
    private Integer id;

    private String name;

    private Date date;

    private LocalDateTime localDateTime;
}
