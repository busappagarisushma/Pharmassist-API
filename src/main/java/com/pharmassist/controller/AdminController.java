package com.pharmassist.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.service.AdminService;

@RestController
public class AdminController {

	private final AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	
	
}
