package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("hrms/api/candidates")
public class CandidateController {
	
	CandidateService candidateService;
	
	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}



	@PostMapping("/signup")
	public Result signUp(@RequestBody Candidate candidate) {
		
		return candidateService.signUp(candidate);  
		
	}
	
	@GetMapping("getall")
	public DataResult<List<Candidate>> getAll(){	
		return candidateService.getAll();
	}

}
