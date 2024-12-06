package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.requestdto.AdminRequest;
import com.pharmassist.responsedto.AdminResponse;
import com.pharmassist.service.AdminService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ResponseStructure;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Admin Controller",description = "The Controller provides end-point to operate on Admin Entity")
public class AdminController {

	private final AdminService adminService;
	private final AppResponseBuilder appResponseBuilder;


	public AdminController(AdminService adminService, AppResponseBuilder appResponseBuilder) {
		super();
		this.adminService = adminService;
		this.appResponseBuilder = appResponseBuilder;
	}


	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody @Valid AdminRequest adminRequest){
		AdminResponse adminResponse = adminService.saveAdmin(adminRequest);
		return appResponseBuilder.success(HttpStatus.CREATED, "Admin Created",adminResponse);
	}
}
