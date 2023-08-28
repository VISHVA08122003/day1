package com.example.spring.day6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.spring.day6.model.PageModel;
import com.example.spring.day6.repository.PageRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PageServiceImpl implements PageService{
	
	@Autowired
	private PageRepository pageRepository;

	@Override
	public List<PageModel> getUser() {
		return pageRepository.findAll();
	}

	@Override
	public boolean addUser(PageModel user) {
		
		boolean userExists = pageRepository.existsById(user.getBabyId());
		if(!userExists) {
			pageRepository.save(user);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean updateUser(int babyId, PageModel user) {
		Optional<PageModel> existingUserOptional=pageRepository.findById(babyId);
		if(existingUserOptional.isPresent()){
		PageModel userExists = existingUserOptional.get();
		userExists.setBabyFirstName(user.getBabyFirstName());;
		userExists.setBabyLastName(user.getBabyLastName());
		userExists.setFatherName(user.getFatherName());
		userExists.setMotherName(user.getMotherName());
		userExists.setAddress(user.getAddress());
		pageRepository.save(userExists);
		return true;
	}else {
		return false;
		}
	}

	@Override
	public boolean deleteUser(int babyId) {
		Optional<PageModel>existingUserOptional = pageRepository.findById(babyId);
		if(existingUserOptional.isPresent()) {
			pageRepository.deleteById(babyId);
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public Page<PageModel> getAllUser(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return  pageRepository.findAll(pageRequest);
	}

//	@Override
//	public PageModel getId(int id) {
//		// TODO Auto-generated method stub
//		return pageRepository.findById(id);
//	}
	
	

}
