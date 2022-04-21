package com.example.speproject.service;

import com.example.speproject.bean.Campaign;
import com.example.speproject.dao.campgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class campgServiceImpl implements campgService{
    @Autowired
    private campgDao campgdao;

    @Override
    public Campaign getCampgByid(Long id) {
        return campgdao.getById(id);
    }
}
