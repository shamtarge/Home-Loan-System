package com.homeloan.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.homeloan.admin.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Modifying
	@Transactional
	@Query(value="update admin set password = :password where user_name = :username", nativeQuery = true)
	void updatePasswordByUsername(@Param("username") String username, @Param("password") String password);

	@Query(value="select * from admin where user_name = :userName", nativeQuery = true)
	Admin searchAdminByUserName(@Param("userName") String userName);
	
	@Query(value="select * from admin where password = :password", nativeQuery = true)
	Admin searchAdminByPassword(@Param("password") String password);

	@Query(value="select * from admin where password = :password and user_name = :userName", nativeQuery = true)
	Admin findByPassword(@Param("password") String password, @Param("userName") String userName);

	

}
