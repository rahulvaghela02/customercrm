package com.CustomerCRM.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CustomerCRM.entity.Address;
import com.CustomerCRM.entity.User;
import com.CustomerCRM.repository.AddressRepository;
import com.CustomerCRM.repository.UserRepository;
import com.CustomerCRM.service.UserService;



@Controller
public class UserController {
	
	private UserService userService;
	
	private AddressRepository addressRepository;
	
	private UserRepository userRepository;
	
	public UserController(UserService userService,UserRepository userRepository,AddressRepository addressRepository) {
		
		this.userService = userService;
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	
	}

	@RequestMapping("/listAllUsers")
	public String getAllUsers(Model model)
	{
	    List<User> allUsers = userRepository.findAll();
	    for (User user : allUsers) {
	        Address address = user.getAddress();
	        if (address != null) {
	            address = addressRepository.findById(address.getId()).orElse(null);
	            user.setAddress(address);
	        }
	    }
	    model.addAttribute("users", allUsers);
	    return "list_users";
	}


	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public String viewCreateUser(Model model)
	{
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        return "createUser";
    }
   
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveOneUser(@ModelAttribute("user") User user, BindingResult result, 
    		Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) 
	{
      
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("image");

        if (file != null && !file.isEmpty()) {
            try {
                byte[] imageData = file.getBytes();
                user.setImage(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Address address = userService.createAddress(user.getAddress());

        user.setAddress(address);

        userService.createOneUser(user);

        redirectAttributes.addFlashAttribute("user", user);
        redirectAttributes.addFlashAttribute("msg", "Record Has Been Saved");
        return "redirect:/user/info/" + user.getId();
    }



    @RequestMapping(value = "/user/info/{id}", method = RequestMethod.GET)
    public String getUserInfo(@PathVariable("id") Long id, Model model)
    {
        User user = userService.findOneUser(id);
        model.addAttribute("user", user);
        return "user_info";
    }
    
    @RequestMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Long id)
    {
        byte[] image = userService.findImageById(id);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String viewUpdateUser(@PathVariable("id") Long id, Model model)
	{
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("address", user.getAddress());
		return "updateUser";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user, @ModelAttribute("address") Address address,
	                          @PathVariable("id") Long id, Model model) {
	    address = userService.updateAddress(address.getId(), address); 
	    user.setAddress(address); 
	    user.setId(id);
	    userService.updateUser(id, user); 
	    User updatedUser = userService.getOneUser(id); 
	    model.addAttribute("user", updatedUser);
	    
	    model.addAttribute("address", updatedUser.getAddress());
	    model.addAttribute("msg", "Record Has Been Updated");
	    return "user_info";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") Long id)
	{
	    userService.deleteUser(id);
	    return "redirect:/listAllUsers";
	}



}
