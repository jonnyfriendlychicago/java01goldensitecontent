package com.jonfriend.java01goldensitecontent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonfriend.java01goldensitecontent.models.TwintwoMdl;
import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;

@Repository
public interface TwintwoRpo extends CrudRepository<TwintwoMdl, Long> {
	
	List<TwintwoMdl> findAll();
	
	TwintwoMdl findByIdIs(Long id);
	
	List<TwintwoMdl> findAllByTwinoneMdl(TwinoneMdl twinoneMdl);
	
	List<TwintwoMdl> findByTwinoneMdlNotContains(TwinoneMdl twinoneMdl);
}
