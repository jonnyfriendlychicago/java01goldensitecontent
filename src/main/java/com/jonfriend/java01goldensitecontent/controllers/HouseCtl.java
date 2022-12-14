package com.jonfriend.java01goldensitecontent.controllers;

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
import com.jonfriend.java01goldensitecontent.services.HouseSrv;
import com.jonfriend.java01goldensitecontent.services.TwinoneSrv;
import com.jonfriend.java01goldensitecontent.services.UserSrv;

@Controller
public class HouseCtl {

	@Autowired
	private HouseSrv houseSrv;
	
	@Autowired
	private TwinoneSrv twinoneSrv;
	
	@Autowired
	private UserSrv userSrv;
	
	// view all record
	@GetMapping("/house")
	public String showAllHouse(
			@ModelAttribute("house") HouseMdl houseMdl // this needed to display create-new on the page
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(authenticatedUserId));
		
		List<HouseMdl> houseList = houseSrv.returnAll();
		model.addAttribute("houseList", houseList);
		
		return "house/list.jsp";
	}
	
	// display create-new page
	@GetMapping("/house/new")
	public String newHouse(
			@ModelAttribute("house") HouseMdl houseMdl
			, Model model
			, HttpSession session
			) {
		 
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId)); 
		model.addAttribute("path", "createInitial"); // this line prob extraneous
		
		return "house/create.jsp"; 
	}
	 
	// process the create-new   
	@PostMapping("/house/new")
	public String addNewHouse(
			@Valid @ModelAttribute("house") HouseMdl houseMdl
			, BindingResult result
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		if(result.hasErrors()) {			
			model.addAttribute("path", "errorOnCreate"); 
			return "house/create.jsp";
		} else {
			// below gets the userModel object by calling the user service with the session user id
			UserMdl currentUserMdl = userSrv.findById(userId);
			// below sets the userId of the new record with above acquisition.
			houseMdl.setUserMdl( currentUserMdl);
			// below creates the record
			houseSrv.create(houseMdl);
			
			return "redirect:/house";
		}
	}
	
	// process the create-new-from-list-page   
	@PostMapping("/house/newFromList")
	public String addNewHouseFromList(
			@Valid @ModelAttribute("house") HouseMdl houseMdl
			, BindingResult result
			, Model model
			, HttpSession session
			) {
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		if(result.hasErrors()) {			
			
			List<HouseMdl> houseList = houseSrv.returnAll();
			model.addAttribute("houseList", houseList);
			
			model.addAttribute("path", "errorOnCreate"); 
			
			return "house/list.jsp";
		} else {

			// below gets the userModel object by calling the user service with the session user id
			UserMdl currentUserMdl = userSrv.findById(userId);
			// below sets the userId of the new record with above acquisition.
			houseMdl.setUserMdl( currentUserMdl);
			// below creates the record
			houseSrv.create(houseMdl);
			
			return "redirect:/house";
		}
	}
	
	
	// view record
	@GetMapping("/house/{id}")
	public String showHouse(
			@PathVariable("id") Long id
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		HouseMdl intVar = houseSrv.findById(id);
		
		model.addAttribute("house", intVar);
		model.addAttribute("childTwinone", twinoneSrv.getAssignedHouse(intVar));
//		model.addAttribute("unassignedCategories", twintwoSrv.getUnassignedHouses(intVar));
		
		return "house/record.jsp";
	}
	
	// display edit page
	@GetMapping("/house/{id}/edit")
	public String editHouse(
			@PathVariable("id") Long houseId
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		// pre-populates the values in the management interface
		HouseMdl intVar = houseSrv.findById(houseId);
		
		model.addAttribute("house", intVar);
		
		return "house/edit.jsp";
	}
	
	// process the edit
	@PostMapping("/house/edit")
	public String PostTheEditHouse(
			@Valid 
			@ModelAttribute("house") HouseMdl houseMdl 
			, BindingResult result
			, Model model
			, HttpSession session
			, RedirectAttributes redirectAttributes
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// trying here to stop someone from forcing this method when not creator; was working, now no idea.... sigh 7/19 2pm
//		 Long userId = (Long) session.getAttribute("userId"); 
//		 PublicationMdl intVar = houseSrv.findById(houseId);
		
		// System.out.println("in the postMapping for edit..."); 
		// System.out.println("intVar.getUserMdl().getId(): " + intVar.getUserMdl().getId()); 
		// System.out.println("userId: " + userId); 
		
//		if(intVar.getUserMdl().getId() != userId) {
//			redirectAttributes.addFlashAttribute("mgmtPermissionErrorMsg", "Only the creator of a record can edit it.");
//			return "redirect:/publication";
//		}
		
		// below now setting up intVar object by using the getID on the modAtt thing. 
		HouseMdl intVar = houseSrv.findById(houseMdl.getId());
		
		if (result.hasErrors()) { 
			
            Long userId = (Long) session.getAttribute("userId");
            model.addAttribute("user", userSrv.findById(userId));            
//            model.addAttribute("house", intVar);

			return "house/edit.jsp";
		} else {
		
			houseMdl.setUserMdl(intVar.getUserMdl());
			// translation of line above: we are reSETTING on the house model object/record the createbyid to that which is GETTING the creatingbyid from the DB... NO LONGER from that silly hidden input. 

			houseSrv.update(houseMdl);
			return "redirect:/house/" + intVar.getId();
		}
	}

	
	// delete house
    @DeleteMapping("/house/{id}")
    public String deleteHouse(
    		@PathVariable("id") Long houseId
    		, HttpSession session
    		, RedirectAttributes redirectAttributes
    		) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		Long userId = (Long) session.getAttribute("userId"); 
		HouseMdl intVar = houseSrv.findById(houseId); 
		
		// below is to prevent non-creator from deleting record
//		if(intVar.getUserMdl().getId() != userId) {
//			redirectAttributes.addFlashAttribute("mgmtPermissionErrorMsg", "Only the creator of a record can delete it.");
//			return "redirect:/publication";
//		}
		
		// below checks if any child twinone records, and if so, prevents the parent house record from being deleted
		
		// in below, the get... is used instead of the ninjaList atty b/c it's private, need to use the getter instead
    	if ( intVar.getTwinoneList().size() > 0 ) {
    		redirectAttributes.addFlashAttribute("errorMsg", "This house record cannot be deleted.  It contains twinone records.");
    		return "redirect:/house/" + houseId;
    		
    	} 
    	
		houseSrv.delete(intVar);
        return "redirect:/home";
    }
	
    
// end of ctl
}
