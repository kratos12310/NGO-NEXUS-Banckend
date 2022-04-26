package com.example.speproject.dao;

import com.example.speproject.bean.DonateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface donatedetailsDao extends JpaRepository<DonateDetails,Long> {


}
