package com.homeloan.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.admin.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
