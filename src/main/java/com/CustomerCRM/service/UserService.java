package com.CustomerCRM.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.CustomerCRM.entity.Address;
import com.CustomerCRM.entity.User;
import com.CustomerCRM.repository.AddressRepository;
import com.CustomerCRM.repository.UserRepository;


@Service
public class UserService {

	private UserRepository userRepository;
	private AddressRepository addressRepository;
	
	public UserService(UserRepository userRepository,AddressRepository addressRepository) 
	{
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}

	public void createOneUser(User user) 
	{
		userRepository.save(user);
	}

	public List<User> getAllUsers() 
	{
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	

	public User updateUser(Long id, @Valid User user) 
	{
	    User user2 = userRepository.findById(id).get();
	    user2.setName(user.getName());
	    user2.setEmail(user.getEmail());
	    user2.setMobileNumber(user.getMobileNumber());
	    User savedUser = userRepository.save(user2);
	    return savedUser;
	}


	public User getUserById(Long id) 
	{
	    return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	}


    public Address createAddress(Address address) 
    {
        return addressRepository.save(address);
    }

  
    public Address updateAddress(Long id, Address address) 
    {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id " + id));
        existingAddress.setStreet(address.getStreet());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setCountry(address.getCountry());
        existingAddress.setZip(address.getZip());
        return addressRepository.save(existingAddress);
    }

	public User getOneUser(Long id) 
	{
		 return userRepository.findById(id).get();
		
	}

	public User findOneUser(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}

	public byte[] findImageById(Long id) {
        return userRepository.findImageById(id);
    }
	
	public User findOneUserByMobileNumber(String mobileNumber) {
	    return userRepository.findByMobileNumber(mobileNumber);
	}

	public void deleteUser(Long id) {
	    userRepository.deleteById(id);
	}

}
