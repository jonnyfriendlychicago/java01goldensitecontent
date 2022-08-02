package com.jonfriend.java01goldensitecontent.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jonfriend.java01goldensitecontent.models.OnetwinchildMdl;
import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;
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
	@GetMapping("/twinone/{id}/onetwinchild")
	public String newOnetwinchild(
			@PathVariable ("id") Long twinoneId
			, @ModelAttribute("onetwinchild") OnetwinchildMdl onetwinchildMdl
			, Model model
			, HttpSession session
			) {
		 
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		// getting the parent record from the pathvariable
		TwinoneMdl intVar = twinoneSrv.findById(twinoneId);
		// sending that parent record to the page
		model.addAttribute("twinone", intVar);
		// placeholder for getting/sending list of already created onetwinchild
		
		return "onetwinchild/create.jsp"; 
	}
	 
	// process the create-new  
	@PostMapping("/twinone/{id}/onetwinchild")
	public String addNewOnetwinchild(
			@PathVariable ("id") Long twinoneId
			, @Valid @ModelAttribute("onetwinchild") OnetwinchildMdl onetwinchildMdl
			, BindingResult result
			, Model model
			, HttpSession session
			) {
		
		// log out the unauth / deliver the auth use data
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		// below gets us the twinone object by using incoming path variable 
		TwinoneMdl intVar = twinoneSrv.findById(twinoneId);
		
		if(result.hasErrors()) {
			
			// getting the parent record from the pathvariable
			TwinoneMdl intVar2 = twinoneSrv.findById(twinoneId);
			// sending that parent record to the page
			model.addAttribute("twinone", intVar2);
			
			return "onetwinchild/create.jsp";
		} else {
			
// ****** below: will be usable if/when OTC has created by field
//			// this gets the userModel object by calling the user service with the seeion user id
//			UserMdl currentUserMdl = userSrv.findById(userId);
//			// below sets the userId of the new record with above acquisition.
//			onetwinchildMdl.setUserMdl( currentUserMdl);
			
// JRF no idea why below is updating the first record instead of inserting new ones. At this point I"m just guessing for new solution.  
		//			// below sets the twinoneid of the new record with above acquisition.
		//			onetwinchildMdl.setTwinoneMdl(intVar); 
		//			onetwinchildSrv.create(onetwinchildMdl);
			
			// JRF very late night: below is working... wow
			OnetwinchildMdl newOtc = new OnetwinchildMdl();
			newOtc.setTwinoneMdl(intVar); 
			newOtc.setOnetwinchildName(onetwinchildMdl.getOnetwinchildName()); 
			onetwinchildSrv.create(newOtc);
			
//			return "redirect:/twinone/" + twinoneId + "/onetwinchild";
			return "redirect:/twinone/" + twinoneId ;
		}
	} 
// end of ctl
}
