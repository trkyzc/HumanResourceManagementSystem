package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	//("Select new com.example.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p ")
	//Select * from JobAdvert j innerJoin Employer e on e.user_id == j.user_id innerJoin Position p on j.position_id == p.id
	//@Query("Select new com.example.hrms.entities.dtos.JobAdvertDao() From JobAdvert j Inner Join Employer e on  ")
	List<JobAdvertDto> getActiveJobAdvert();

}
