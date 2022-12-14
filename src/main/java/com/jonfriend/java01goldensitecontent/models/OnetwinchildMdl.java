package com.jonfriend.java01goldensitecontent.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
//JRF: keep below OUT when building the autoJoinTbl solution
//import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity
@Table(name="onetwinchild")
public class OnetwinchildMdl {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // begin: entity-specific table fields
   
    @NotBlank
    private String onetwinchildName;
    
	private String onetwinchildDesc;
	
	private float onetwinchildFloat; 
	
	private Integer onetwinchildInt; 
	
	private String onetwinchildLookup; 
	
	//	@Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date onetwinchildDate;
    
    // end: entity-specific table fields
    
    // start: code for joins
    
    // join user table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="createdby_id")
    private UserMdl userMdl;  
    
    // join twinone table 
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="twinone_id")
	private TwinoneMdl twinoneMdl;  

    // end: code for joins
    
    // instantiate the model: 
    public OnetwinchildMdl() {}
    
    // add methods to populate maintain createdAt/UpdatedAt
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
        // getters and setters - start
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getOnetwinchildName() {
		return onetwinchildName;
	}

	public void setOnetwinchildName(String onetwinchildName) {
		this.onetwinchildName = onetwinchildName;
	}

	public String getOnetwinchildDesc() {
		return onetwinchildDesc;
	}

	public void setOnetwinchildDesc(String onetwinchildDesc) {
		this.onetwinchildDesc = onetwinchildDesc;
	}

	public float getOnetwinchildFloat() {
		return onetwinchildFloat;
	}

	public void setOnetwinchildFloat(float onetwinchildFloat) {
		this.onetwinchildFloat = onetwinchildFloat;
	}

	public Integer getOnetwinchildInt() {
		return onetwinchildInt;
	}

	public void setOnetwinchildInt(Integer onetwinchildInt) {
		this.onetwinchildInt = onetwinchildInt;
	}

	public String getOnetwinchildLookup() {
		return onetwinchildLookup;
	}

	public void setOnetwinchildLookup(String onetwinchildLookup) {
		this.onetwinchildLookup = onetwinchildLookup;
	}

	public Date getOnetwinchildDate() {
		return onetwinchildDate;
	}

	public void setOnetwinchildDate(Date onetwinchildDate) {
		this.onetwinchildDate = onetwinchildDate;
	}

	public UserMdl getUserMdl() {
		return userMdl;
	}

	public void setUserMdl(UserMdl userMdl) {
		this.userMdl = userMdl;
	}

	public TwinoneMdl getTwinoneMdl() {
		return twinoneMdl;
	}

	public void setTwinoneMdl(TwinoneMdl twinoneMdl) {
		this.twinoneMdl = twinoneMdl;
	}

    
    // getters and setters - end
    
// end mdl
}
