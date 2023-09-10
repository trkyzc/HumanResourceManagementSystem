package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.JobAdvert;


@Service
public class EmployerManager implements EmployerService {
	
	EmployerDao employerDao;
	

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}


	@Override
	public Result signUp(Employer employer) {
		
		if(employer.getCompanyName()== null || employer.getWebAddress()==null ||  
				employer.getEmail()==null ||  employer.getPhoneNumber()==null || 
				employer.getPassword()==null ||  employer.getRepeatedPassword()==null) {
			
			return new ErrorResult("Please fill in all fields.");
		}
		else {
			if(!employerDao.findByEmail(employer.getEmail()).isEmpty()) {
				return new ErrorResult("Bu mail daha önce kullanılmış");   
			}
			else {
				employerDao.save(employer);
				return new SuccessResult("The employer has been successfully registered.");
			}
		}
	}

	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"İşverenler başarıyla listelendi.");
	}


	

}
