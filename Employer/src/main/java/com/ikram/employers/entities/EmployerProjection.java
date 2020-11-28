package com.ikram.employers.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomEmployer", types = { Employer.class })
public interface EmployerProjection {
public String getNomEmployer();
}