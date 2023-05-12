package com.CustomerCRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CustomerCRM.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
