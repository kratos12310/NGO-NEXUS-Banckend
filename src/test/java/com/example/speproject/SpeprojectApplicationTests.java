package com.example.speproject;

import com.example.speproject.bean.*;
import com.example.speproject.dao.*;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpeprojectApplicationTests {


    @Autowired
    ngoDao ngodao;

    @Autowired
    donorDao donordao;

    @Autowired
    donatedetailsDao donatedetailsdao;

    //testing login for Ngo
    @Test
    public void loginTest() {
        Ngo n = ngodao.findByEmailEqualsAndPasswordEquals("wom@gm.com", "password");
        Long check = n.getId();
        Assert.assertNotNull(check);
    }
    // testing logging for Donor
    @Test
    public void dloginTest(){
        Donor d = donordao.findByEmailEqualsAndPasswordEquals("astha@gm.com", "password");
        Long check2 = d.getId();
        Assert.assertNotNull(check2);
    }
    //testing Fetching ngo by category
    @Test
    public void fetchNgoByCategoryTest() {
        List<Ngo> ngoList = ngodao.findByCategory("Women Empowerment");
        String catg = "Women Empowerment";
        if (ngoList.size() != 0) {
            Ngo ng = ngoList.get(0);
            Assert.assertEquals(catg, ng.getCategory());
        }
    }
    //testing search of ngo
    @Test
    public void fetchNgoBySearchTest() {
        List<Ngo> ngoList = ngodao.findByNameOrCategory("Angel", "Angel");
        String query = "Angel";
        if (ngoList.size() != 0) {
            Ngo ng = ngoList.get(0);
            //Assert.assertEquals(catg,ng.getCategory()||name,ng.getName());
            assertThat(query, Matchers.either(Matchers.is(ng.getName())).or(Matchers.is(ng.getCategory())));
        }
    }
    //Testing getting ngo by id
    @Test
    public void fetchNgoByIdTest() {
        Long i=Long.valueOf(1);
        Ngo ngo = ngodao.findById(i).get();
        Assert.assertEquals(i,ngo.getId());
    }
    //testing Donor by id
    @Test
    public void fetchDonorByIdTest() {
        Long i=Long.valueOf(1);
        Donor donor = donordao.findById(i).get();
        Assert.assertEquals(i,donor.getId());
    }

//    @Test
//    public void UpdateNgoByIdTest() {
//        Long i=Long.valueOf(1);
//        String email="wom@gm.com";
//        DonateDetails donatedetails=new DonateDetails(i,ngodao.findById(i).get(),donordao.findById(i).get(),500,"pari","satya");
//        Ngo ng=new Ngo(i,"Angel","Women Empowerment","Nari Shakti","Hyderabad","Assam","9435560505","Save Her","She is Power","Saving Life","password","Saving Life",email,"", (List<DonateDetails>) donatedetails);
//        ngodao.save(ng);
//        Assert.assertEquals(ngodao.findById(i).get().getName(), ng.getName());
//    }

//    @Test
//    public void DeleteNgoByIdTest() {
//        Long i=Long.valueOf(1);
//        ngodao.deleteById(i);
//        Assert.assertFalse(ngodao.findById(i).isPresent());
//    }





}
