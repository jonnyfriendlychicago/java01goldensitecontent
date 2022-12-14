package com.jonfriend.java01goldensitecontent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java01goldensitecontent.models.HouseMdl;
//import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;
import com.jonfriend.java01goldensitecontent.repositories.HouseRpo;

@Service
public class HouseSrv {
	
	// adding the house repository as a dependency
	private final HouseRpo houseRpo;
	
	public HouseSrv(HouseRpo houseRpo) {this.houseRpo = houseRpo;}
	
	// creates one house 
	public HouseMdl create(HouseMdl x) {
		return houseRpo.save(x);
	}

	// updates one house 
	public HouseMdl update(HouseMdl x) {
		return houseRpo.save(x);
	}
	
	// delete house by id 
	public void delete(HouseMdl x) {
		houseRpo.delete(x);
	}
	
	// returns one house by id 
	public HouseMdl findById(Long id) {
		Optional<HouseMdl> optionalHouse = houseRpo.findById(id);
		if(optionalHouse.isPresent()) {
			return optionalHouse.get();
		}else {
			return null;
		}
	}
	
	// returns all house 
	public List<HouseMdl> returnAll(){
		return houseRpo.findAll();
	}

	// JF something about service below is busted, won't work.  Revisit.
//	// get all joined twinone 
//	public List<HouseMdl> getAssignedTwinones(TwinoneMdl x){
//		return houseRpo.findAllByTwinoneMdl(x);
//	}
	
//	below doesn't work for house
	
//	// get all un-joined twinone 
//	public List<HouseMdl> getUnassignedTwinones(TwinoneMdl x){
//		return houseRpo.findByTwinoneMdlNotContains(x);
//	}
	
	// this is for removing a house-twintwo join record/entry
	
//	public void removeHouseTwintwoJoin(TwintwoMdl c, HouseMdl p ) {
//		List<TwintwoMdl> twintwoList = p.getTwintwoMdl(); 
//		twintwoList.remove(c); 
//		this.houseRpo.save(p); 
//	}
//	
	
}