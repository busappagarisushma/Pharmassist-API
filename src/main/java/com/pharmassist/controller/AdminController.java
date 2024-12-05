package com.pharmassist.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.service.AdminService;
import com.pharmassist.util.AppResponseBuilder;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Admin COntroller",description = "The Controller provides end-point to operate on Admin Entity")
public class AdminController {

	private final AdminService adminService;
	private final AppResponseBuilder appResponseBuilder;


	public AdminController(AdminService adminService, AppResponseBuilder appResponseBuilder) {
		super();
		this.adminService = adminService;
		this.appResponseBuilder = appResponseBuilder;
	}


}
