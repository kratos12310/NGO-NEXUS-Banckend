package com.example.speproject.service;

import com.example.speproject.bean.DonateDetails;

import java.util.List;

public interface donatedetailsService {
    DonateDetails saveDonateDetails(DonateDetails donatedetails);

    List<DonateDetails> getdonatedetailsbyid(Long id);
}
