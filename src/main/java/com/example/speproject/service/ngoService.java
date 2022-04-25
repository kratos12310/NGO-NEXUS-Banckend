package com.example.speproject.service;


import com.example.speproject.bean.Ngo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ngoService {

    public Resource loadImage(Ngo ngo);

    public Ngo saveNgo(Ngo ngo);

    public List<Ngo> fetchNgoList();

   public Ngo FetchNgoById(Long id);

    public void DeleteNgoById(Long id);

   public Ngo UpdateNgoById(Long id, Ngo ngo);



    String uploadImage(MultipartFile file,Long id);


    List<Ngo> fetchNgoByCategory(String category);



    Ngo login(String email, String password);

    List<Ngo> fetchNgoBySearch(String name,String category);
}
