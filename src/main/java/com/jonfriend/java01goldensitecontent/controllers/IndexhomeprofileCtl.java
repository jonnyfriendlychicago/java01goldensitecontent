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

import com.jonfriend.java01goldensitecontent.models.LoginUserMdl;


import com.jonfriend.java01goldensitecontent.models.UserMdl;
import com.jonfriend.java01goldensitecontent.models.UserupdateMdl;
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

		 
		model.addAttribute("newLogin", new LoginUserMdl()); // putting a new empty LoginUserMdl obj on the index page,
//        model.addAttribute("newUser", new UserMdl());  // login no longer on the same page as register
        
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
    	
        if(result.hasErrors() || user==null ) // user==null is the equiv of "user name not found!"
        {
        	model.addAttribute("newUser", new UserMdl()); //deliver the empty UserMdl object before re-rendering the reg/login page; the LoginUserMdl obj will maintain the incoming values to this method
            return "index.jsp";
        }
    
        session.setAttribute("userId", user.getId()); // No errors?  Store the ID from the DB in session.
	    return "redirect:/home";
    }
    
	@GetMapping("/register")
	public String register(
			Model model
			, HttpSession session) {
		
		if(session.getAttribute("userId") != null) {return "redirect:/home";} // redirect authorized users to the /home METHOD; don't expose the index page to already-authenticated users

        model.addAttribute("newUser", new UserMdl()); // login/reg form items: putting a new empty UserMdl obj for on the index page, so user can shove data into it using the form.
//        model.addAttribute("newLogin", new LoginUserMdl()); // login no longer on the same page as register
        
        System.out.println("Page Display: Register"); 
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
            // deliver the empty LoginUser object before re-rendering the reg/login page; the UserMdl obj will maintain the incoming values to this method
//            model.addAttribute("newLogin", new LoginUserMdl()); // this delivery of empty loginUser object is no longer needed, since login/reg on sep pages
            return "register.jsp";
        }
        
        session.setAttribute("userId", user.getId());  // this is a repeat of the last line of the login method
	    return "redirect:/home";
    }
     
    @GetMapping("/logout")
	public String logout(
			HttpSession session
			) {
		// below nulls the session.userId value, which prevents access to any/all page(s) other than index, thus redirect to index. 
    	session.setAttribute("userId", null);
    	System.out.println("User logged out."); 
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
			model.addAttribute("authUser", userSrv.findById(userId));
			
//			List<TwinoneMdl> intVar3 = twinoneSrv.returnAll();
//			model.addAttribute("twinoneList", intVar3);

			System.out.println("Page Display: Home"); 
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
			model.addAttribute("authUser", userSrv.findById(userId));
			
			// grab the entire user object using the url parameter, then deliver to page
			UserMdl userObj = userSrv.findById(userProfileId);
			model.addAttribute("userProfile", userObj); 
			
			System.out.println("Page Display: Profile"); 
			return "profile/record.jsp";
		}
		
		// display edit page
		@GetMapping("/profile/{id}/edit")
		public String editProfile(
				@ModelAttribute("userProfileTobe") UserupdateMdl userupdateMdl
				, @PathVariable("id") Long userProfileId
				, Model model
				, HttpSession session
				) {
			
			// log out the unauth / deliver the auth use data
			if(session.getAttribute("userId") == null) {return "redirect:/logout";}
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("authUser", userSrv.findById(userId));
			
			// pre-populates the values in the management interface
//			UserMdl intVar = userSrv.findById(userProfileId); // delivered mdl aint working
//			model.addAttribute("userProfile", intVar); // delivered mdl aint working
			
			UserMdl userProfileObj = userSrv.findById(userProfileId); // delivered mdl aint working
			model.addAttribute("userProfileAsis", userProfileObj); // delivered mdl aint working
			
//			model.addAttribute("userProfileTobe", new UserupdateMdl());
			
			System.out.println("Page Display: ProfileEdit");
			return "profile/edit.jsp";
		}
		
		// process the edit
		@PostMapping("/profile/edit")
		public String PostTheEditProfile(
				@Valid 
				@ModelAttribute("userProfileTobe") UserupdateMdl userupdateMdl
				, BindingResult result
				, Model model
				, HttpSession session
				, RedirectAttributes redirectAttributes
				) {
			
			// log out the unauth / deliver the auth use data
			if(session.getAttribute("userId") == null) {return "redirect:/logout";}
			Long authenticatedUserId = (Long) session.getAttribute("userId");
			System.out.println("authenticatedUserId: " + authenticatedUserId); 
//			model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
			
			// below now setting up the object by using the getID on the modAtt thing. 
//			UserMdl userProfileObj = userSrv.findById(userMdl.getId());
			
			UserMdl currentUserMdl = userSrv.findById(authenticatedUserId); //  gets the userModel object by calling the user service with the session user id
			
			
			
//			JRF: next two lines old bad useless stuff
//			userMdl.setPassword(userProfileObj.getPassword()); 
//			userMdl.setConfirm(userProfileObj.getPassword()); // jrf adding this, on a whim... no idea if affecting
			
			
//			System.out.println("userProfileObj.getPassword(): " + userProfileObj.getPassword()); 
			
			if (result.hasErrors() ) { 
				
				System.out.println("on profile/edit error path"); 
				
//				Long authenticatedUserId = (Long) session.getAttribute("userId");
//	            model.addAttribute("user", userSrv.findById(authenticatedUserId));            
////	            System.out.println("userMdl.setPassword(userProfileObj.getPassword()); :: " + userMdl.setPassword(userProfileObj.getPassword()));
//	            System.out.println("result.getErrorCount: " + result.getErrorCount() ); 
//	            System.out.println("result.getAllErrors: " + result.getAllErrors() ); 
	            
				return "profile/edit.jsp";
			} else {
			
//				userMdl.setUserMdl(intVar.getUserMdl());
				// translation of line above: we are reSETTING on the house model object/record the createbyid to that which is GETTING the creatingbyid from the DB... NO LONGER from that silly hidden input. 
				
//				.setUserMdl(userProfileObj.getUserMdl());
				
				currentUserMdl.setEmail(userupdateMdl.getEmail()); 
				currentUserMdl.setUserName(userupdateMdl.getUserName()); 
				currentUserMdl.setFirstName(userupdateMdl.getFirstName() ); 
				currentUserMdl.setLastName(userupdateMdl.getLastName() ); 
				currentUserMdl.setConfirm("hello");  
				
				System.out.println("currentUserMdl.getPassword(): " + currentUserMdl.getPassword() ); 
				
				userSrv.update(currentUserMdl);
				
				return "redirect:/"; 
			}
		}
		
// end of ctl methods
}
