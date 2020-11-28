package com.ikram.employers.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ikram.employers.entities.Employer;
import com.ikram.employers.service.EmployerService;

@Controller
public class EmployerController {
	
	
	@Autowired
	EmployerService employerService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("employer", new Employer());
	modelMap.addAttribute("mode", "edit");
	return "formEmployer";
	}
	
	
	@RequestMapping("/saveEmployer")
	public String saveEmployer(@Valid Employer employer,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formEmployer";

	employerService.saveEmployer(employer);
	return "formEmployer";
	}

	
	
	@RequestMapping("/ListeEmployers")
	public String listeEmployers(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Employer> emps = employerService.getAllEmployersParPage(page, size);
	modelMap.addAttribute("employers", emps);
	 modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeEmployers";
	}

	
	@RequestMapping("/supprimerEmployer")
	public String supprimerEmployer(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
		employerService.deleteEmployertById(id);
	Page<Employer> emps = employerService.getAllEmployersParPage(page,
	size);
	modelMap.addAttribute("employers", emps);
	modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeEmployers";
	}
	
	
	@RequestMapping("/modifierEmployer")
	public String editerEmployer(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Employer emp= employerService.getEmployer(id);
	modelMap.addAttribute("employer", emp);
	modelMap.addAttribute("mode", "edit");
	return "formEmployer";
	}
	
	
	
	@RequestMapping("/updateEmployer")
	public String updateEmployer(@ModelAttribute("employer") Employer employer,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateDebut = dateformat.parse(String.valueOf(date));
	 employer.setDateDebut(dateDebut);

	 employerService.updateEmployer(employer);
	 List<Employer> emps = employerService.getAllEmployers();
	 modelMap.addAttribute("employers", emps);
	return "listeEmployers";
	}
	
	
	
	
	
	}


