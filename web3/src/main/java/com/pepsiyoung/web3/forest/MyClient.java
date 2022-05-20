package com.pepsiyoung.web3.forest;

import com.dtflys.forest.annotation.Request;
import org.springframework.stereotype.Component;

@Component
public interface MyClient {

    @Request(url = "https://jsonplaceholder.typicode.com/posts")
    String simpleRequest();
}
