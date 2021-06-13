package com.mywebapplication.creatings.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mywebapplication.creatings.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
//List<Alien>findbyname(String name);
//List<Alien>findbyidGraterthan(int aid);
//@Query("from Alen where aid=?1orderby aname")
//List<Alien>findbysortedaname(String aname);
}
