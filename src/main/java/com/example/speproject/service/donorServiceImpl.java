package com.example.speproject.service;


import com.example.speproject.bean.Donor;
import com.example.speproject.dao.donorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class donorServiceImpl implements donorService{
    @Autowired
    private donorDao donordao;

    @Override
    public Donor saveDonor(Donor donor){
        return donordao.save(donor);
    }

    @Override
    public Donor getDonor(Donor donor) {
        return  null;
    }

    @Override
    public Donor dlogin(String email, String password) {
        return donordao.findByEmailEqualsAndPasswordEquals(email,password);
    }

    @Override
    public Donor FetchDonorById(Long id) {
        return donordao.findById(id).get();
    }
}
