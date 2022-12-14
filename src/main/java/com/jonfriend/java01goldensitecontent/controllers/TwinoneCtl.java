package com.jonfriend.java01goldensitecontent.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jonfriend.java01goldensitecontent.models.UserMdl;
import com.jonfriend.java01goldensitecontent.models.HouseMdl;
import com.jonfriend.java01goldensitecontent.models.OnetwinchildMdl;
import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;
import com.jonfriend.java01goldensitecontent.services.HouseSrv;
import com.jonfriend.java01goldensitecontent.services.OnetwinchildSrv;
import com.jonfriend.java01goldensitecontent.services.TwinoneSrv;
import com.jonfriend.java01goldensitecontent.services.UserSrv;

@Controller
public class TwinoneCtl {

	@Autowired
	private TwinoneSrv twinoneSrv;
	
//	@Autowired
//	private TwintwoSrv twintwoSrv;
	
	@Autowired
	private UserSrv userSrv;
	
	@Autowired
	private HouseSrv houseSrv;
	
	@Autowired
	private OnetwinchildSrv onetwinchildSrv; 
	
	// view all record
	@GetMapping("/twinone")
	public String showAllTwinone(
			@ModelAttribute("twinone") TwinoneMdl twinoneMdl // this needed to display create-new on the page
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		List<TwinoneMdl> twinoneList = twinoneSrv.returnAll();
		model.addAttribute("twinoneList", twinoneList);
		
		return "twinone/list.jsp";
	}
	
	// display create-new page
	@GetMapping("/twinone/new")
	public String newTwinone(
			@ModelAttribute("twinone") TwinoneMdl twinoneMdl
			, Model model
			, HttpSession session
			) {
		 
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		// records in house dropdown
		List<HouseMdl> intVar1 = houseSrv.returnAll();
		model.addAttribute("houseList", intVar1);    
		
		return "twinone/create.jsp";
	}
	 
	// process the create-new  
	@PostMapping("/twinone/new")
	public String addNewTwinone(
			@Valid @ModelAttribute("twinone") TwinoneMdl twinoneMdl
			, BindingResult result
			, Model model
			, HttpSession session
			, RedirectAttributes redirectAttributes
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		if(result.hasErrors()) {
			return "twinone/create.jsp";
		} else {

			// below gets the userModel object by calling the user service with the session user id
			UserMdl currentUserMdl = userSrv.findById(authenticatedUserId);
			// below sets the userId of the new record with above acquisition.
			twinoneMdl.setUserMdl( currentUserMdl);
			
			twinoneSrv.create(twinoneMdl);
			redirectAttributes.addFlashAttribute("successMsg", "New Twinone created and added to list below.");
			return "redirect:/twinone";
		}
	}
	
	// view record
	@GetMapping("/twinone/{id}")
	public String showTwinone(
			@PathVariable("id") Long id
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth user data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		UserMdl currentUserMdl = userSrv.findById(authenticatedUserId); 
		TwinoneMdl twinoneObj = twinoneSrv.findById(id);
		
		// start: fun with functions & loops
		
		List<OnetwinchildMdl> onetwinchildList = twinoneObj.getOnetwinchildList(); // instantiate the java list
		
		Integer onetwinchildCount = onetwinchildList.size(); // get a count of how many items in the list
		
		Integer sumOnetwinchildDotOnetwinchildInt = 0; // instantiate the java variable that we will update in the loop 
		Boolean onetwinchildExistsCreatedByAuthUser = false; // instantiate the java variable that we will update in the loop
		
		
		for (int i=0; i < onetwinchildCount; i++  ) {
			System.out.println("value of item in drawer " + i + " -- " + onetwinchildList.get(i).getOnetwinchildInt()); 
			sumOnetwinchildDotOnetwinchildInt += onetwinchildList.get(i).getOnetwinchildInt(); 
			System.out.println("sum: " + sumOnetwinchildDotOnetwinchildInt); 
			if (onetwinchildList.get(i).getUserMdl().equals(currentUserMdl) )
			{onetwinchildExistsCreatedByAuthUser = true; 
			} // if there's a a match, set to true.  that's it, that's all you gotta do.  
			System.out.println("onetwinchildExistsCreatedByAuthUser: " + onetwinchildExistsCreatedByAuthUser);
		}
		
//		// below is a great while-loop, but unnecessary as we've incorporated the userCheck into the for-loop above.  If for-loop above didn't exist, while-loop below would be ideal.
//		int i = 0; 
//		while  (i < onetwinchildCount && onetwinchildExistsCreatedByAuthUser == false
//				) 
//		{
//			if (onetwinchildList.get(i).getUserMdl().equals(currentUserMdl) )
//				{onetwinchildExistsCreatedByAuthUser = true; 
//				} else {
//				i++; 
//			}
//		}
//		
//		System.out.println("onetwinchildExistsCreatedByAuthUser: " + onetwinchildExistsCreatedByAuthUser); 

		// end: fun with functions & loops
		
		model.addAttribute("twinone", twinoneObj);
		model.addAttribute("onetwinchildList", onetwinchildSrv.getAssignedTwinones(twinoneObj));
		model.addAttribute("onetwinchildCount", onetwinchildCount); 
		model.addAttribute("sumOnetwinchildDotOnetwinchildInt", sumOnetwinchildDotOnetwinchildInt); 
		model.addAttribute("onetwinchildExistsCreatedByAuthUser", onetwinchildExistsCreatedByAuthUser);
		
		
		return "twinone/record.jsp";
	}
	
	
	
	
	// display edit page
	@GetMapping("/twinone/{id}/edit")
	public String editTwinone(
			@PathVariable("id") Long twinoneId
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth user data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		// pre-populates the values in the management interface
		TwinoneMdl twinoneObj = twinoneSrv.findById(twinoneId);
		
		// below gets the userModel object by calling the user service with the session user id
		UserMdl currentUserMdl = userSrv.findById(authenticatedUserId);
		UserMdl recordCreatorUserMdl = twinoneObj.getUserMdl(); 
		System.out.println("currentUserMdl: " + currentUserMdl); 
		System.out.println("recordCreatorUserMdl: " + recordCreatorUserMdl); 
		
		// records in house dropdown
		List<HouseMdl> houseList = houseSrv.returnAll();
		model.addAttribute("houseList", houseList);  
		
		model.addAttribute("twinone", twinoneObj);
//		model.addAttribute("assignedCategories", twintwoSrv.getAssignedTwinones(intVar));
//		model.addAttribute("unassignedCategories", twintwoSrv.getUnassignedTwinones(intVar));

		List<OnetwinchildMdl> onetwinchildList = twinoneObj.getOnetwinchildList(); // instantiate the java list	
		Boolean hasOneOrMoreOnetwinchild = false; 
		
		if ( onetwinchildList.size() > 0 ) {
			hasOneOrMoreOnetwinchild = true;
		}
		model.addAttribute("hasOneOrMoreOnetwinchild", hasOneOrMoreOnetwinchild);
		System.out.println("hasOneOrMoreOnetwinchild: " + hasOneOrMoreOnetwinchild); 
		return "twinone/edit.jsp";
	}
	
	// process the edit(s)
	@PostMapping("/twinone/edit")
	public String PostTheEditTwinone(
			@Valid 
			@ModelAttribute("twinone") TwinoneMdl twinoneMdl 
			, BindingResult result
			, Model model
			, HttpSession session
			, RedirectAttributes redirectAttributes
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		// below now setting up twinone object by using the getID on the modAtt thing. 
		TwinoneMdl twinoneObj = twinoneSrv.findById(twinoneMdl.getId());
		
		
		UserMdl currentUserMdl = userSrv.findById(authenticatedUserId); //  gets the userModel object by calling the user service with the session user id
		UserMdl recordCreatorUserMdl = twinoneObj.getUserMdl();   // gets the userMdl obj saved to the existing twinoneObj 
		
		if(!currentUserMdl.equals(recordCreatorUserMdl)) {
			System.out.println("recordCreatorUserMdl != currentUserMdl, so redirected to record"); 
			redirectAttributes.addFlashAttribute("permissionErrorMsg", "This record can only be edited by its creator.  Any edits just attempted were discarded.");
			return "redirect:/twinone/" + twinoneObj.getId();
		}
		

		if (result.hasErrors()) { 
			// modAtt needed for page already set in lines before above 'if' (authUser), so don't need to repeat here
			// redirectAttributes doesn't work here b/c we are not redirecting, we are merely returning.  so use modAtt instead.
//			redirectAttributes.addFlashAttribute("validationErrorMsg", "Updates not saved, errors found.  See details in form below.");
			model.addAttribute("validationErrorMsg", "Errors found, updates not applied.  See details in form below.");
			return "twinone/edit.jsp";
		} else {
			twinoneMdl.setUserMdl(twinoneObj.getUserMdl()); // shove the existing user mdl from the db/obj into the obj about to be saved. 
			twinoneSrv.update(twinoneMdl);
			return "redirect:/twinone/" + twinoneObj.getId();
		}
	}
	
//	// process new joins for that one twinone
//	@PostMapping("/twinone/{id}/editTwintwoJoins")
//	public String postTwinoneTwintwoJoin(
////			@PathVariable("id") Long id
//			@PathVariable("id") Long twinoneId
//			, @RequestParam(value="twintwoId") Long twintwoId // requestParam is only used with regular HTML form 
//			,  Model model
//			, HttpSession session
//			) {
//		
//		// log out the unauth / deliver the auth user data
//		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		Long AuthenticatedUserId = (Long) session.getAttribute("userId");
//		model.addAttribute("authUser", userSrv.findById(AuthenticatedUserId));
//		
//		TwinoneMdl twinone = twinoneSrv.findById(twinoneId);
//		TwintwoMdl twintwo = twintwoSrv.findById(twintwoId);
//		
//		twinone.getTwintwoMdl().add(twintwo);
//		
//		twinoneSrv.update(twinone);
//		
//		// need these two below so that the returned page has this dropdown/table info populated.
//		model.addAttribute("assignedCategories", twintwoSrv.getAssignedTwinones(twinone));
//		model.addAttribute("unassignedCategories", twintwoSrv.getUnassignedTwinones(twinone));
////		return "redirect:/twinone/" + id;
//		return "redirect:/twinone/" + twinoneId + "/edit";
//	}
//	
//	@DeleteMapping("/removeTwinoneTwintwoJoin")
//    public String removeTwinoneTwintwoJoin(
//    		@RequestParam(value="twintwoId") Long twintwoId // requestParam is only used with regular HTML form
//    		, @RequestParam(value="twinoneId") Long twinoneId // requestParam is only used with regular HTML form
//    		// below removed, outmoded design
// //    		, @RequestParam(value="origin") Long originPath // requestParam is only used with regular HTML form
//    		, HttpSession session
//    		, RedirectAttributes redirectAttributes
//    		) {
//
//		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		Long AuthenticatedUserId = (Long) session.getAttribute("userId");
//		// model.addAttribute("authUser", userSrv.findById(AuthenticatedUserId));
//
//		TwinoneMdl twinoneObject = twinoneSrv.findById(twinoneId);
//		TwintwoMdl twintwoObject  = twintwoSrv.findById(twintwoId);
//		
//		twinoneSrv.removeTwinoneTwintwoJoin(twintwoObject, twinoneObject); 
//		
//		return "redirect:/twinone/" + twinoneId + "/edit";
//	}
	
	// delete twinone
    @DeleteMapping("/twinone/{id}")
    public String deleteTwinone(
    		@PathVariable("id") Long twinoneId
    		, HttpSession session
    		, RedirectAttributes redirectAttributes
    		) {
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long AuthenticatedUserId = (Long) session.getAttribute("userId");
		// JRF: above AuthenticatedUserId not being used rigth now, but we will (stop delete by bogus user)
		// model.addAttribute("authUser", userSrv.findById(AuthenticatedUserId));
		
		TwinoneMdl twinoneObj = twinoneSrv.findById(twinoneId);
		
		// below is to prevent non-creator from deleting record
//		if(intVar.getUserMdl().getId() != userId) {
//			redirectAttributes.addFlashAttribute("mgmtPermissionErrorMsg", "Only the creator of a record can delete it.");
//			return "redirect:/publication";
//		}

		List<OnetwinchildMdl> onetwinchildList = twinoneObj.getOnetwinchildList(); // instantiate the java list	
		
		if ( onetwinchildList.size() > 0 ) {
			System.out.println("Delete hack attempted on twinone record");
			redirectAttributes.addFlashAttribute("permissionErrorMsg", "This event has onetwinchild records, so it cannot be deleted.  If all user RSVPs get deleted, you can then delete this event.  Event no longer happening?  Then update the twinoneStatus to be Cancelled.");
			return "redirect:/twinone/" + twinoneObj.getId();
		}
			
		twinoneSrv.delete(twinoneObj);
        return "redirect:/twinone";
    }
	

// end of methods
}
