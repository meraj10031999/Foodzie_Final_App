package com.youtube.jwt.controller;

import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.response.MessageResponse;
import com.youtube.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

@RestController
@CrossOrigin
public class UserController {
	
	 @Autowired
	    private UserDao userDao;

	    @Autowired
	    private RoleDao roleDao;

	    @Autowired
	    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public ResponseEntity<MessageResponse> registerNewUser(@RequestBody User user) {
    	 Role role = roleDao.findById("User").get();
         Set<Role> userRoles = new HashSet<>();
         userRoles.add(role);
         user.setRole(userRoles);
         user.setUserPassword(getEncodedPassword(user.getUserPassword()));

         userDao.save(user);
         return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
