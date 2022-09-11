package com.spring.mvc.dao;

import com.spring.mvc.entity.Labor;

import java.util.List;

public interface LaborDAO {
    List<Labor> getAllLabors();

    void saveLabor(Labor labor);

    Labor getLaborById(int id);

    void deleteLabor(int id);
}