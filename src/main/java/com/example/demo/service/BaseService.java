package com.example.demo.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BaseService<V,T> {

    //get
    T findOne(Long id);
    T findAll(String keyword, Pageable pageable);

    //save
    T save(V request);

    //delete
    void delete(Long[] ids);

    //--------//
//    int totalItem();;
}
