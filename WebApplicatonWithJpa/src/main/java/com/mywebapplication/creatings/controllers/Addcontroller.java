package com.mywebapplication.creatings.controllers;

import java.util.List;
import java.util.Optional;
import com.mywebapplication.creatings.model.Alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.mywebapplication.creatings.dao.AlienRepo;

//@Controller
//@RequestMapping("/alien/{aid}")
@RestController
public class Addcontroller {
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

//	@RequestMapping("/addAlien")
//	public ModelAndView addAlien(Alien alien) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("obj", alien);
//		mv.setViewName("result.jsp");
//		mv.addObject(alien);
//		repo.save(alien);
//		return mv;
//
//	}

//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("showresult.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());
//		mv.addObject(alien);
////		System.out.println(repo.findbyidGraterthan(101));
////		System.out.println(repo.findbysortedaname("srikanth"));
//		return mv;
		

	//}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a=repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@RequestMapping("/aliens")
	public List<Alien> getAliens() {
		
		return repo.findAll();

	}
	
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {

		return repo.findById(aid);
		

	}
	 
	//@PutMapping(path="/aliens")
	@RequestMapping(value = "/alien/{aid}", method = RequestMethod.PUT)
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	@PostMapping("/alien")
	public Alien postAliens(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;

	}
	@GetMapping(path= "/alien")
public List<Alien> getAllAliens() {
		
		return repo.findAll();

	}

}
