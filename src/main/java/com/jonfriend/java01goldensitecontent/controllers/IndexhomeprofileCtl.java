package com.jonfriend.java01goldensitecontent.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.jonfriend.java01goldensitecontent.models.HouseMdl;
import com.jonfriend.java01goldensitecontent.models.LoginUserMdl;


import com.jonfriend.java01goldensitecontent.models.UserMdl;

import com.jonfriend.java01goldensitecontent.services.UserSrv;

@Controller
public class IndexhomeprofileCtl {
	
	@Autowired
	private UserSrv userSrv;
	
	 
// ********************************************************************
// AUTHENTICATION METHODS
// ********************************************************************
	
	@GetMapping("/")
	public String index(
			Model model
			, HttpSession session) {
		
		// *** Redirect authorized users to the /home METHOD -- DON'T EXPOSE REG/LOGIN index page TO ALREADY AUTH'ED USERS ***
		if(session.getAttribute("userId") != null) {return "redirect:/home";}

		// login/reg form items: putting a new empty UserMdl obj for reg and new empty LoginUserMdl obj on the index page, so user can shove data into it using the form. 
//        model.addAttribute("newUser", new UserMdl());
        model.addAttribute("newLogin", new LoginUserMdl());
        
        System.out.println("Page Display: login"); 
		return "index.jsp"; 
	}

    @PostMapping("/login")
    public String login(
    		@Valid @ModelAttribute("newLogin") LoginUserMdl newLogin
    		, BindingResult result
    		, Model model
    		, HttpSession session
    		) {
    	
    	UserMdl user = userSrv.login(newLogin, result);
    	
    	// user==null below is the equiv of "user name not found!"
        if(result.hasErrors() || user==null ) {
        	// Below sends in the empty UserMdl object before re-rendering the reg/login page; the LoginUserMdl obj will maintain the incoming values to this method
        	model.addAttribute("newUser", new UserMdl());
            return "index.jsp";
        }
    
     // No errors?  Store the ID from the DB in session.  This is the equivalent of the end result of the /login method described below. 
        session.setAttribute("userId", user.getId());
   	 
	    return "redirect:/home";
    }
    
	@GetMapping("/register")
	public String register(
			Model model
			, HttpSession session) {
		
		// *** Redirect authorized users to the /home METHOD -- DON'T EXPOSE REG/LOGIN index page TO ALREADY AUTH'ED USERS ***
		if(session.getAttribute("userId") != null) {return "redirect:/home";}

		// login/reg form items: putting a new empty UserMdl obj for reg and new empty LoginUserMdl obj on the index page, so user can shove data into it using the form. 
        model.addAttribute("newUser", new UserMdl());
//        model.addAttribute("newLogin", new LoginUserMdl());
        
        System.out.println("Page Display: reg"); 
		return "register.jsp"; 
	}
	
    @PostMapping("/register")
    public String register(
    		@Valid @ModelAttribute("newUser") UserMdl newUser
    		, BindingResult result
    		, Model model
    		, HttpSession session
    		) {
        
    	UserMdl user = userSrv.register(newUser, result);
        
        if(result.hasErrors()) {
            // Below sends in the empty LoginUser object before re-rendering the reg/login page; the UserMdl obj will maintain the incoming values to this method
            model.addAttribute("newLogin", new LoginUserMdl());
            return "register.jsp";
        }
        
        // No errors?  Store the ID from the DB in session.  This is the equivalent of the end result of the /login method described below.  
        // In other words, we are bypassing the /login method with next line. 
        session.setAttribute("userId", user.getId());
   	 
	    return "redirect:/home";
    }
     
    @GetMapping("/logout")
	public String logout(
			HttpSession session
			) {
		// below nulls the session.userId value, which prevents access to any/all page(s) other than index, thus redirect to index. 
    	session.setAttribute("userId", null);
	    return "redirect:/";
	}

//********************************************************************
// HOME/PROFILE/ETC METHODS
//********************************************************************
		
	    @GetMapping("/home")
		public String home(
				Model model
				, HttpSession session
				) {
		 
	    	// log out the unauth vs. deliver the auth user data
			if(session.getAttribute("userId") == null) {return "redirect:/logout";}
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userSrv.findById(userId));
			
//			List<TwinoneMdl> intVar3 = twinoneSrv.returnAll();
//			model.addAttribute("twinoneList", intVar3);

			System.out.println("Page Display: home"); 
		    return "home.jsp";  
		}

		// display user profile page
		@GetMapping("/profile/{id}")
		public String showProfile(
				@PathVariable("id") Long userProfileId
				, Model model
				, HttpSession session
				) {
			
	    	// log out the unauth vs. deliver the auth user data
			if(session.getAttribute("userId") == null) {return "redirect:/logout";}
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userSrv.findById(userId));
			
			// grab the entire user object using the url parameter, then deliver to page
			UserMdl intVar = userSrv.findById(userProfileId);
			model.addAttribute("userProfile", intVar);
			
			System.out.println("Page Display: Profile"); 
			return "profile/record.jsp";
		}
		
		// display edit page
		@GetMapping("/profile/{id}/edit")
		public String editProfile(
				@PathVariable("id") Long userProfileId
				, Model model
				, HttpSession session
				) {
			
			// log out the unauth / deliver the auth use data
			if(session.getAttribute("userId") == null) {return "redirect:/logout";}
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userSrv.findById(userId));
			
			// pre-populates the values in the management interface
			UserMdl intVar = userSrv.findById(userProfileId);
			model.addAttribute("userProfile", intVar);
			
			System.out.println("Page Display: ProfileEdit");
			return "profile/edit.jsp";
		}
		
		// process the edit
		@PostMapping("/profile/edit")
		public String PostTheEditProfile(
				@Valid 
				@ModelAttribute("userProfile") UserMdl userMdl 
				, BindingResult result
				, Model model
				, HttpSession session
				, RedirectAttributes redirectAttributes
				) {
			
			// log out the unauth / deliver the auth use data
			if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//			Long authenticatedUserId = (Long) session.getAttribute("userId");
			
			// below now setting up intVar object by using the getID on the modAtt thing. 
			UserMdl userProfileObj = userSrv.findById(userMdl.getId());
			
			userMdl.setPassword(userProfileObj.getPassword()); 
			System.out.println("userProfileObj.getPassword(): " + userProfileObj.getPassword()); 
			
			if (result.hasErrors() ) { 
				
				System.out.println("on profile/edit error path"); 
				Long authenticatedUserId = (Long) session.getAttribute("userId");
	            model.addAttribute("user", userSrv.findById(authenticatedUserId));            
//	            System.out.println("userMdl.setPassword(userProfileObj.getPassword()); :: " + userMdl.setPassword(userProfileObj.getPassword()));  
	            
				return "profile/edit.jsp";
			} else {
			
//				userMdl.setUserMdl(intVar.getUserMdl());
				// translation of line above: we are reSETTING on the house model object/record the createbyid to that which is GETTING the creatingbyid from the DB... NO LONGER from that silly hidden input. 
				
//				.setUserMdl(userProfileObj.getUserMdl());
				
				userSrv.update(userMdl);
				return "redirect:/profile/" + userProfileObj.getId();
			}
		}
		
// end of ctl methods
}
