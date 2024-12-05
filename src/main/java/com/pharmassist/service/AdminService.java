package com.pharmassist.service;

import org.springframework.stereotype.Service;

import com.pharmassist.repository.AdminRepository;

@Service
public class AdminService {

	private final AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
}
