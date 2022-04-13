package com.pepsiyoung.web2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pepsiyoung.web2.entity.Person;
import com.pepsiyoung.web2.mapper.PersonMapper;
import com.pepsiyoung.web2.service.IPersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {
}
