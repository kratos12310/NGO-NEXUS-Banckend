package com.example.speproject.dao;

import com.example.speproject.bean.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface campgDao extends JpaRepository<Campaign, Long> {
}
