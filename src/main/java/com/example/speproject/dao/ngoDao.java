package com.example.speproject.dao;

import com.example.speproject.bean.Ngo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ngoDao extends JpaRepository<Ngo,Long> {
 List<Ngo> findByCategory(String category);
}
