package com.jonfriend.java01goldensitecontent.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jonfriend.java01goldensitecontent.models.OnetwinchildMdl;
import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;
import com.jonfriend.java01goldensitecontent.models.UserMdl;
import com.jonfriend.java01goldensitecontent.services.OnetwinchildSrv;
import com.jonfriend.java01goldensitecontent.services.TwinoneSrv;
import com.jonfriend.java01goldensitecontent.services.UserSrv;

@Controller
//public class OnetwinchildCtl {
public class OnetwinchildCtl {

	@Autowired
	private OnetwinchildSrv onetwinchildSrv;
	
	@Autowired
	private UserSrv userSrv;
	
	@Autowired
	private TwinoneSrv twinoneSrv;
	
	// display create-new page
	@GetMapping("/twinone/{id}/onetwinchild/new")
	public String newOnetwinchild(
			@PathVariable ("id") Long twinoneId
			, @ModelAttribute("onetwinchild") OnetwinchildMdl onetwinchildMdl
			, Model model
			, HttpSession session
			) {
		 
		// log out the unauth / deliver the auth user data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		// getting the parent record from the pathvariable
		TwinoneMdl twinoneObj = twinoneSrv.findById(twinoneId);
		// sending that parent record to the page
		model.addAttribute("twinone", twinoneObj);
		// placeholder for getting/sending list of already created onetwinchild

		return "onetwinchild/create.jsp"; 
	}
	 
	// process the create-new  
	@PostMapping("/twinone/{id}/onetwinchild/create")
	public String addNewOnetwinchild(
			@PathVariable ("id") Long twinoneId
			, @Valid @ModelAttribute("onetwinchild") OnetwinchildMdl onetwinchildMdl
			, BindingResult result
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		// below gets us the twinone object by using incoming path variable 
		TwinoneMdl twinoneObj = twinoneSrv.findById(twinoneId);
		
		if(result.hasErrors()) {
			
			// sending the parent record to the page
			model.addAttribute("twinone", twinoneObj);
			
			return "onetwinchild/create.jsp";
		} else {
			
			// first... get current user whole object, for infusion into onetwinchild record
			UserMdl currentUserMdl = userSrv.findById(authenticatedUserId); 
			
			// begin: code design from platform
			// first, instantiate the new object
			OnetwinchildMdl newOtc = new OnetwinchildMdl(); // ... and next: infuse into that object all the values from the incoming model/form
			newOtc.setTwinoneMdl(twinoneObj); // parent record
			newOtc.setUserMdl(currentUserMdl); // user that is creating it
			newOtc.setOnetwinchildName(onetwinchildMdl.getOnetwinchildName()); 
			newOtc.setOnetwinchildDesc(onetwinchildMdl.getOnetwinchildDesc()); 
			newOtc.setOnetwinchildFloat(onetwinchildMdl.getOnetwinchildFloat()); 
			newOtc.setOnetwinchildInt(onetwinchildMdl.getOnetwinchildInt());
			newOtc.setOnetwinchildLookup(onetwinchildMdl.getOnetwinchildLookup()); 
			newOtc.setOnetwinchildDate(onetwinchildMdl.getOnetwinchildDate()); // and next: create via service
			onetwinchildSrv.create(newOtc);
			// end: code design from platform
			
			// begin: JRF/cam refactor, which should create new perfectly.. but instead just updates the most recently created record
//			onetwinchildMdl.setUserMdl( currentUserMdl);
//			onetwinchildMdl.setTwinoneMdl(twinoneObj); 
//			onetwinchildSrv.create(onetwinchildMdl);
			// end: JRF/cam refactor
			
			return "redirect:/twinone/" + twinoneId ;
		}
	} 
	
	// view record
	@GetMapping("/onetwinchild/{id}")
	public String showOnetwinchild(
			@PathVariable("id") Long onetwinchildId
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long AuthenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(AuthenticatedUserId));
		
		OnetwinchildMdl onetwinchildObj = onetwinchildSrv.findById(onetwinchildId); // get the object that is the primary object displayed on this page
		TwinoneMdl twinoneObj = onetwinchildObj.getTwinoneMdl(); // get the object that is the parent to the primary object
		
		model.addAttribute("onetwinchild", onetwinchildObj); // deliver the object that is the primary object on this page 
		model.addAttribute("twinone", twinoneObj);   // deliver the object that is the parent to the primary object on this page
		
//		model.addAttribute("onetwinchildList", onetwinchildSrv.getAssignedTwinones(twinoneObj));
//		model.addAttribute("assignedCategories", twintwoSrv.getAssignedTwinones(twinoneObj));
//		model.addAttribute("unassignedCategories", twintwoSrv.getUnassignedTwinones(twinoneObj));
		
		return "onetwinchild/record.jsp";
	}
	
	// display edit page
	@GetMapping("/onetwinchild/{id}/edit")
	public String editOnetwinchild(
			@PathVariable("id") Long onetwinchildId
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth user data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long AuthenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(AuthenticatedUserId));
		
		OnetwinchildMdl onetwinchildObj = onetwinchildSrv.findById(onetwinchildId); // get the object that is the primary object displayed on this page
		TwinoneMdl twinoneObj = onetwinchildObj.getTwinoneMdl(); // get the object that is the parent to the primary object
		
		model.addAttribute("onetwinchild", onetwinchildObj); // deliver the object that is the primary object on this page 
		model.addAttribute("twinone", twinoneObj);   // deliver the object that is the parent to the primary object on this page

		return "onetwinchild/edit.jsp";
	}
	
	// process the edit
	@PostMapping("/onetwinchild/edit")
	public String PostTheEditOnetwinchild(
//			@PathVariable ("id") Long twinoneId
			@Valid @ModelAttribute("onetwinchild") OnetwinchildMdl onetwinchildMdl
			, BindingResult result
			, Model model
			, HttpSession session
			, RedirectAttributes redirectAttributes
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long authenticatedUserId = (Long) session.getAttribute("userId");
		model.addAttribute("authUser", userSrv.findById(authenticatedUserId));
		
		// below now setting up rthe onetwinchild object by using the getID on the modAtt thing. 
		OnetwinchildMdl onetwinchildObj = onetwinchildSrv.findById(onetwinchildMdl.getId());
		TwinoneMdl twinoneObj = onetwinchildObj.getTwinoneMdl(); // get the object that is the parent to the primary object
		
		Long onetwinchildID = onetwinchildObj.getId(); 
		
		if(result.hasErrors()) {
			
			// sending the parent record to the page
			model.addAttribute("twinone", twinoneObj);
			
//			Long AuthenticatedUserId = (Long) session.getAttribute("userId");
//            model.addAttribute("user", userSrv.findById(AuthenticatedUserId));  
//            // getting the parent record from the pathvariable
//			TwinoneMdl intVar2 = twinoneSrv.findById(twinoneId);
//			// sending that parent record to the page
//			model.addAttribute("twinone", intVar2);
			
			return "onetwinchild/create.jsp";
		} else {
			
			// first... get current user whole object, for infusion into onetwinchild record
			//UserMdl currentUserMdl = userSrv.findById(authenticatedUserId); 
			
			// actually, get the user object that created it in the first place, that's what we want to maintain
			UserMdl origCreatorUserMdl = onetwinchildObj.getUserMdl();  // get the object that is the parent to the primary object
			
			// begin: code design from platform
			// ... and next: instantiate the new object
//			OnetwinchildMdl newOtc = new OnetwinchildMdl(); // ... and next: infuse into that object all the values from the incoming model/form
//			newOtc.setTwinoneMdl(twinoneObj); // parent record
//			newOtc.setUserMdl(origCreatorUserMdl); // user that is editing it
//			newOtc.setId(onetwinchildMdl.getId()); 
//			newOtc.setOnetwinchildName(onetwinchildMdl.getOnetwinchildName()); 
//			newOtc.setOnetwinchildDesc(onetwinchildMdl.getOnetwinchildDesc()); 
//			newOtc.setOnetwinchildFloat(onetwinchildMdl.getOnetwinchildFloat()); 
//			newOtc.setOnetwinchildInt(onetwinchildMdl.getOnetwinchildInt());
//			newOtc.setOnetwinchildLookup(onetwinchildMdl.getOnetwinchildLookup()); 
//			newOtc.setOnetwinchildDate(onetwinchildMdl.getOnetwinchildDate()); // and next: create via service
//			onetwinchildSrv.update(newOtc);
			// end: code design from platform
			
			// begin: JRF/cam refactor, which should create new perfectly.. but instead just updates the most recently created record
			onetwinchildMdl.setUserMdl( origCreatorUserMdl);
			onetwinchildMdl.setTwinoneMdl(twinoneObj); 
			onetwinchildSrv.update(onetwinchildMdl);
			// end: JRF/cam refactor
			
//			return "redirect:/twinone/" + twinoneId + "/onetwinchild";
			return "redirect:/onetwinchild/" + onetwinchildID;
		}
	} 
	
	// delete onetwinchild
    @DeleteMapping("/onetwinchild/{id}")
    public String deleteOnetwinchild(
    		@PathVariable("id") Long onetwinchildId
    		, HttpSession session
    		, RedirectAttributes redirectAttributes
    		) {
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
//		Long AuthenticatedUserId = (Long) session.getAttribute("userId");

		OnetwinchildMdl onetwinchildObj = onetwinchildSrv.findById(onetwinchildId);
		
		// below is to prevent non-creator from deleting record
//		if(intVar.getUserMdl().getId() != userId) {
//			redirectAttributes.addFlashAttribute("mgmtPermissionErrorMsg", "Only the creator of a record can delete it.");
//			return "redirect:/publication";
//		}

		onetwinchildSrv.delete(onetwinchildObj);
        return "redirect:/home";
    }
// end of methods
}
