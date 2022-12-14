package com.jonfriend.java01goldensitecontent.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jonfriend.java01goldensitecontent.models.LoginUserMdl;
import com.jonfriend.java01goldensitecontent.models.UserMdl;
import com.jonfriend.java01goldensitecontent.repositories.UserRpo;

@Service
public class UserSrv{
    
    @Autowired
    private UserRpo userRpo;

    public UserMdl register(
    		UserMdl newUser
    		, BindingResult result
    		) {
        
    	Optional<UserMdl> potentialUser = userRpo.findByEmail(newUser.getEmail());
    	
    	// Reject if email exists in db
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists.");
    	}
    	
    	// reject if pw/confirm don't match
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
        // Return null if result has errors
        if(result.hasErrors()) {
            // Exit the method and go back to the controller to handle the response
            return null;
        }
        
     // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
    	return userRpo.save(newUser);
    }
    
    public UserMdl login(
    		LoginUserMdl newLogin
    		, BindingResult result
    		) {
    	
    	Optional<UserMdl> potentialUser = userRpo.findByEmail(newLogin.getEmail());

    	// Find user in the DB by email and reject if NOT present
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User email not found");
    		return null;
    	}
    	
    	// User exists, retrieve user from DB
    	UserMdl user = potentialUser.get();
    	
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password.");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		// Exit the method and go back to the controller 	
    		return null;
    	}
    	
    	potentialUser.isPresent(); //notsureif needed 

    	return user;
    }
    
    // below used on every page beginning with /home.  Delivers user object of logged in user, so as to display various user attributes. 
    
    public UserMdl findById(
    		Long id
    		) {
    	Optional<UserMdl> potentialUser = userRpo.findById(id);

//    	if(potentialUser.isPresent()) {
//    		return potentialUser.get();}
//    	return null;

    	// JRF: above replaced by below
       	
    	if(!potentialUser.isPresent()) {
       		return null;}
    		
       	return potentialUser.get();
    	
    }
    
    // JRF: I think below can be removed... tbd. actually (8/4), I think I created this to return a list of users, that's it/all. 
 // returns all user
 	public List<UserMdl> returnAll(){
 		return userRpo.findAll();
 	}
 	
 	// Update a user
 	public UserMdl update(UserMdl x) {
 		
 		// placeholder for checking: email already in use?  username already in use? 
 		
 		return userRpo.save(x);
 	}
    

 	
 	
}
