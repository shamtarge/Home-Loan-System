package com.homeloan.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.homeloan.admin.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Modifying
	@Transactional
	@Query(value="update admin set adminPassword = :password where adminId = :adminId", nativeQuery = true)
	void updatePasswordByAdminId(@Param("adminId") long adminId, @Param("password") String password);

}
