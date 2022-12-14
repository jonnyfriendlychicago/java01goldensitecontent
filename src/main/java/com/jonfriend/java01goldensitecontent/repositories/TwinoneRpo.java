package com.jonfriend.java01goldensitecontent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonfriend.java01goldensitecontent.models.TwintwoMdl;
import com.jonfriend.java01goldensitecontent.models.HouseMdl;
import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;

@Repository
public interface TwinoneRpo extends CrudRepository<TwinoneMdl, Long> {
	
	List<TwinoneMdl> findAll();
	
	TwinoneMdl findByIdIs(Long id);
	
	List<TwinoneMdl> findAllByTwintwoMdl(TwintwoMdl twintwoMdl);
	
	List<TwinoneMdl> findByTwintwoMdlNotContains(TwintwoMdl twintwoMdl);
	
	// trying to get house to work
	
//	findAllByHouseMdl
	
	List<TwinoneMdl> findAllByHouseMdl(HouseMdl houseMdl);
	
	
}
