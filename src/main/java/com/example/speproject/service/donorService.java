package com.example.speproject.service;

import com.example.speproject.bean.Donor;
import com.example.speproject.bean.Ngo;

public interface donorService {
    public Donor saveDonor(Donor donor);

    Donor getDonor(Donor donor);
    Donor dlogin(String email, String password);

    Donor FetchDonorById(Long id);
}
