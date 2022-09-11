package com.spring.mvc.service;

import com.spring.mvc.dao.LaborDAO;
import com.spring.mvc.entity.Labor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceDaoImpl implements ServiceDao{
    @Autowired
    private LaborDAO laborDAO;

    @Override
    @Transactional
    public List<Labor> getAllLabors(){
        return laborDAO.getAllLabors();
    }

    @Override
    @Transactional
    public void saveLabor(Labor labor) {
        laborDAO.saveLabor(labor);
    }

    @Override
    @Transactional
    public Labor getLaborById(int id) {
        return laborDAO.getLaborById(id);
    }

    @Override
    @Transactional
    public void deleteLabor(int id) {
        laborDAO.deleteLabor(id);
    }
}