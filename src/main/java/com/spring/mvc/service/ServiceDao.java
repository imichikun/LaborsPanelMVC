package com.spring.mvc.service;

import com.spring.mvc.entity.Labor;

import java.util.List;

public interface ServiceDao {
    List<Labor> getAllLabors();

    void saveLabor(Labor labor);

    Labor getLaborById(int id);

    void deleteLabor(int id);
}