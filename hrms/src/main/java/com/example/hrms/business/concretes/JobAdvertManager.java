package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobAdvertDao;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService {
	
	JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result addAdvert(JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İlan başarıyla eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertDto>> getByActiveJobAdverts() {
		
		return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertDao.getByActiveJobAdverts(),"İlanlar başarıyla görüntülendi.");
	}

	@Override
	public DataResult<List<JobAdvertDto>> getAllByOrderByApplicationDateAsc() {
		
		return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertDao.getAllByOrderByApplicationDateAsc(),"İlanlar başarıyla görüntülendi.");
	}

	@Override
	public DataResult<List<JobAdvertDto>> getAllByOrderByApplicationDateDesc() {
		
		return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertDao.getAllByOrderByApplicationDateDesc(),"İlanlar başarıyla görüntülendi.");
	}

	@Override
	public DataResult<List<JobAdvertDto>> getAllByEmployer(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertDao.getAllByEmployer(employerId),"İlanlar başarıyla görüntülendi.");
	}

	@Override
	public Result updateJobAdvertStatus(int id) {
		
		JobAdvert jobAdvert = jobAdvertDao.getById(id);
		jobAdvert.setActive(false);
		jobAdvertDao.save(jobAdvert);
		//jobAdvertDao.updateJobAdvertStatus(id);
		return new SuccessResult();
	}
	
	

}
