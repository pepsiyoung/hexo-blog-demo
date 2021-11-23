package com.pepsiyoung.rabbitmq.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private String title;

    private String author;

    private String content;
}
