package com.example.speproject.dao;

import com.example.speproject.bean.Donor;
import com.example.speproject.bean.Ngo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface donorDao extends JpaRepository<Donor,Long> {
    Donor findByEmailEqualsAndPasswordEquals(String username, String password);


}
