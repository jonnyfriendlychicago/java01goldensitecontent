package com.jonfriend.java01goldensitecontent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import com.jonfriend.java01goldensitecontent.models.TwintwoMdl;
import com.jonfriend.java01goldensitecontent.models.OnetwinchildMdl;
import com.jonfriend.java01goldensitecontent.models.TwinoneMdl;

@Repository
public interface OnetwinchildRpo extends CrudRepository<OnetwinchildMdl, Long> {
	
	List<OnetwinchildMdl> findAll();
	
	OnetwinchildMdl findByIdIs(Long id);
	
	List<OnetwinchildMdl> findAllByTwinoneMdl(TwinoneMdl twinoneMdl);
//	
//	List<OnetwinchildMdl> findByTwintwoMdlNotContains(TwintwoMdl twintwoMdl);
}
