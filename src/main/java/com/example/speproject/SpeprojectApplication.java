package com.example.speproject;

import com.example.speproject.bean.DonateDetails;
import com.example.speproject.bean.Donor;
import com.example.speproject.bean.Ngo;
import com.example.speproject.dao.donorDao;
import com.example.speproject.dao.ngoDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpeprojectApplication {
@Autowired
ngoDao ngodao;

@Autowired
    donorDao donordao;

public static void main(String[] args) {
        SpringApplication.run(SpeprojectApplication.class, args);
    }


    @Bean
    InitializingBean Ngo() {
        return () -> {
            Long i = Long.valueOf(1);
            String email = "wom@gm.com";

            Ngo ngo = ngodao.save(new Ngo(i, "Angel", "Women Empowerment", "Nari Shakti", "Hyderabad", "Assam", "9435560505", "Save Her", "She is Power", "Saving Life", "password", "Saving Life", email, "", null));
            Donor donor = donordao.save(new Donor(i, "Astha", "Astha@gm.com", "password", "8812071725", "Individual", null));
            DonateDetails donatedetails = new DonateDetails(i, ngo, donor, 500, "pari", "satya");
            List<DonateDetails> donateDetailsList = new ArrayList<>();
            donateDetailsList.add(donatedetails);
            ngo.setDonatedetails(donateDetailsList);
            ngodao.save(ngo);
            donor.setDonatedetails(donateDetailsList);
            donordao.save(donor);
        };
    }
}