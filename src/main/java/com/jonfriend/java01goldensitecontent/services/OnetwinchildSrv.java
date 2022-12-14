package com.jonfriend.java01goldensitecontent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java01goldensitecontent.models.OnetwinchildMdl;
import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;
import com.jonfriend.java01goldensitecontent.repositories.OnetwinchildRpo;

@Service
public class OnetwinchildSrv {
	
	// adding the onetwinchild repository as a dependency
	private final OnetwinchildRpo onetwinchildRpo;
	
	public OnetwinchildSrv(OnetwinchildRpo onetwinchildRpo) {this.onetwinchildRpo = onetwinchildRpo;}
	
	// creates one onetwinchild 
	public OnetwinchildMdl create(OnetwinchildMdl x) {
		return onetwinchildRpo.save(x);
	}

	// updates one onetwinchild 
	public OnetwinchildMdl update(OnetwinchildMdl x) {
		return onetwinchildRpo.save(x);
	}
	
	// delete onetwinchild by id 
	public void delete(OnetwinchildMdl x) {
		onetwinchildRpo.delete(x);
	}
	
	// returns one onetwinchild by id 
	public OnetwinchildMdl findById(Long id) {
		Optional<OnetwinchildMdl> optionalOnetwinchild = onetwinchildRpo.findById(id);
		if(optionalOnetwinchild.isPresent()) {
			return optionalOnetwinchild.get();
		}else {
			return null;
		}
	}
	
	// returns all onetwinchild 
	public List<OnetwinchildMdl> returnAll(){
		return onetwinchildRpo.findAll();
	}
	
	// get all joined twinone 
	public List<OnetwinchildMdl> getAssignedTwinones(TwinoneMdl x){
		return onetwinchildRpo.findAllByTwinoneMdl(x);
	}
//	
//	// get all un-joined onetwinchild 
//	public List<OnetwinchildMdl> getUnassignedTwintwos(TwintwoMdl x){
//		return onetwinchildRpo.findByTwintwoMdlNotContains(x);
//	}
//	
//	// this is for removing a onetwinchild-twintwo join record/entry
//	
//	public void removeOnetwinchildTwintwoJoin(TwintwoMdl c, OnetwinchildMdl p ) {
//		List<TwintwoMdl> twintwoList = p.getTwintwoMdl(); 
//		twintwoList.remove(c); 
//		this.onetwinchildRpo.save(p); 
//	}
	
	
}