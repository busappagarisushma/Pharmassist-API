package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmassist.requestdto.AdminRequest;
import com.pharmassist.responsedto.AdminResponse;
import com.pharmassist.service.AdminService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ErrorStructure;
import com.pharmassist.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

	@Operation(description = "The End-point can be used to save the Admin",
			responses = {
					@ApiResponse(responseCode = "201",description = "Admin Created",
							content = {
									@Content(schema = @Schema(implementation = AdminResponse.class))
					}

							),
					@ApiResponse(responseCode = "400",description = "Bad AdminRequest, Invalid Input",
					content = {
							@Content(schema = @Schema(implementation = ErrorStructure.class))
					}
							)
	}
			)

	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody @Valid AdminRequest adminRequest){
		AdminResponse adminResponse = adminService.saveAdmin(adminRequest);
		return appResponseBuilder.success(HttpStatus.CREATED, "Admin Created",adminResponse);
	}


	@Operation(description = "The End-point can be used to find the Admin",
			responses = {
					@ApiResponse(responseCode = "302",description = "Admin Found",
							content = {
									@Content(schema = @Schema(implementation = AdminResponse.class))
					}),
					@ApiResponse(responseCode = "404",description = "Admin Not Found",
					content = {
							@Content(schema = @Schema(implementation = ErrorStructure.class))
					})
	}
			)
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(@PathVariable String adminId){
		AdminResponse adminResponse = adminService.findAdmin(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND, "Admin found by Id", adminResponse);
	}

}
