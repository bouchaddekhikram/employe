package com.ikram.employers.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ikram.employers.entities.Employer;
import com.ikram.employers.service.EmployerService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployerRESTController {
@Autowired
EmployerService employerService;

@RequestMapping(method = RequestMethod.GET)
public List<Employer> getAllEmployers() {
return employerService.getAllEmployers();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Employer getEmployerById(@PathVariable("id") Long id) {
return employerService.getEmployer(id);

}

@RequestMapping(method = RequestMethod.POST)
public Employer createEmployer(@RequestBody Employer employer) {
return employerService.saveEmployer(employer);
}

@RequestMapping(method = RequestMethod.PUT)
public Employer updateEmployer(@RequestBody Employer employer) {
return employerService.updateEmployer(employer);
}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteEmployer(@PathVariable("id") Long id)
{
	employerService.deleteEmployertById(id);
}


@RequestMapping(value="/empsent/{idEnt}",method = RequestMethod.GET)
public List<Employer> getEmployersByEntId(@PathVariable("idEnt") Long idEnt) {
return employerService.findByEntrepriseIdEnt(idEnt);
}

}