package com.CustomerCRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CustomerCRM.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u.image FROM User u WHERE u.id = :id")
    public byte[] findImageById(@Param("id") Long id);

	
	    User findByMobileNumber(String mobileNumber);

	
}
