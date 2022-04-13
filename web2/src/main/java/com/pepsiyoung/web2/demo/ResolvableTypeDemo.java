package com.pepsiyoung.web2.demo;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.springframework.core.ResolvableType;

import java.util.List;

public class ResolvableTypeDemo {
    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(StringList.class);
        System.out.println(resolvableType.resolve());
        System.out.println(resolvableType.asCollection());

//        ResolvableType resolvableType1 = ResolvableType.forRawClass(List.class);
//        System.out.println(resolvableType1.resolve());
    }
}
