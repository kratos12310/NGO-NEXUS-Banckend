package com.example.speproject.service;


import com.example.speproject.bean.Ngo;
import com.example.speproject.dao.ngoDao;
import com.example.speproject.service.ngoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@Service
public class ngoServiceImpl implements ngoService {

    @Autowired
    private ngoDao ngodao;

    //@Value("${ngo_image_upload_location}")
  //  private String image_location=new ClassPathResource("static/images/").getFile().getAbsolutePath();
    private String image_location="./";
    public ngoServiceImpl()throws IOException{}


    @Override
    public Resource loadImage(Ngo ngo) {
            try {
                Path upload_location = Paths.get(image_location);
                Path file = upload_location.resolve(ngo.getLogo());
                Resource resource = new UrlResource(file.toUri());
                if (resource.exists() || resource.isReadable()) {
                    return resource;
                } else {
                    return null;
                }
            } catch (MalformedURLException error) {
                System.out.println("Error: [loadImage][ArtistsServiceImpl] " + error.getLocalizedMessage());
            }
            return null;
    }

    @Override
    public Ngo saveNgo(Ngo ngo) {
        return ngodao.save(ngo);
    }

    @Override
    public List<Ngo> fetchNgoList() {
        return ngodao.findAll();
    }

    @Override
    public Ngo FetchNgoById(Long id) {
        return ngodao.findById(id).get();
    }

    @Override
    public void DeleteNgoById(Long id) {
      ngodao.deleteById(id);
    }

    @Override
    public Ngo UpdateNgoById(Long id, Ngo ngo) {
        Ngo ngodb=ngodao.findById(id).get();

        if(Objects.nonNull(ngo.getName())&& !"".equalsIgnoreCase(ngo.getName())){
            ngodb.setName(ngo.getName());
        }
        if(Objects.nonNull(ngo.getAddress())&& !"".equalsIgnoreCase(ngo.getAddress())){
            ngodb.setAddress(ngo.getAddress());
        }
        if(Objects.nonNull(ngo.getPhoneno())&& !"".equalsIgnoreCase(ngo.getPhoneno())){
            ngodb.setPhoneno(ngo.getPhoneno());
        }
        if(Objects.nonNull(ngo.getDesc())&& !"".equalsIgnoreCase(ngo.getDesc())){
            ngodb.setDesc(ngo.getDesc());
        }
        if(Objects.nonNull(ngo.getEmail())&& !"".equalsIgnoreCase(ngo.getEmail())){
            ngodb.setEmail(ngo.getEmail());
        }
        if(Objects.nonNull(ngo.getCampaign1())&& !"".equalsIgnoreCase(ngo.getCampaign1())){
            ngodb.setCampaign1(ngo.getCampaign1());
        }
        if(Objects.nonNull(ngo.getCampaign2())&& !"".equalsIgnoreCase(ngo.getCampaign2())){
            ngodb.setCampaign2(ngo.getCampaign2());
        }
        if(Objects.nonNull(ngo.getCampaign3())&& !"".equalsIgnoreCase(ngo.getCampaign3())){
            ngodb.setCampaign3(ngo.getCampaign3());
        }
        if(Objects.nonNull(ngo.getLoc())&& !"".equalsIgnoreCase(ngo.getLoc())){
            ngodb.setLoc(ngo.getLoc());
        }
        if(Objects.nonNull(ngo.getVision())&& !"".equalsIgnoreCase(ngo.getVision())){
            ngodb.setVision(ngo.getVision());
        }
        if(Objects.nonNull(ngo.getCategory())&& !"".equalsIgnoreCase(ngo.getCategory())){
            ngodb.setCategory(ngo.getCategory());
        }
        if(Objects.nonNull(ngo.getPassword())&& !"".equalsIgnoreCase(ngo.getPassword())){
            ngodb.setPassword(ngo.getPassword());
        }
        return ngodao.save(ngodb);


    }

    @Override
    public String uploadImage(MultipartFile image, Long id) {

        if (image.getOriginalFilename() == null) {
            return null;
        }
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        System.out.println(fileName);
        if (image.isEmpty()) {
            return "Empty image";
        }
       // if(!image.getContentType().equals("image/jpeg")){
         //   return "Not an image";
        //}
        if (fileName.contains("..")) {
            fileName = fileName.replace("..", "_");
        }
        try (InputStream inputStream = image.getInputStream()) {
           Path upload_location = Paths.get(image_location);
          //  System.out.println(upload_location);
            String s=String.valueOf(id);
            fileName = "logo_" + s+fileName;
            System.out.println(fileName);
            Files.copy(inputStream, upload_location.resolve(fileName),StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException error) {
            System.out.println("Error: [uploadImage][NgoServiceImpl] " + error.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Ngo> fetchNgoByCategory(String category) {
        return ngodao.findByCategory(category);
    }

    @Override
    public Ngo login(String email, String password) {
        return ngodao.findByEmailEqualsAndPasswordEquals(email,password);
    }

    @Override
    public List<Ngo> fetchNgoBySearch(String name,String category) {
        return ngodao.findByNameOrCategory(name,category);
    }


}
