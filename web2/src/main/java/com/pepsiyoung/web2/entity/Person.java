package com.pepsiyoung.web2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName(value = "person", autoResultMap = true)
public class Person {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String hobbyId;

    private String name;

    private LocalDateTime createTime;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Configure configure;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Configure {

        private String name;

        private Integer age;

        private List<Integer> list;
    }
}
