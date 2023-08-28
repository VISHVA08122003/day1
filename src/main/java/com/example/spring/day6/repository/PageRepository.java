package com.example.spring.day6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.day6.model.PageModel;

public interface PageRepository extends JpaRepository<PageModel,Integer>{

}
