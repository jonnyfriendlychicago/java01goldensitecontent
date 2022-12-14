package com.jonfriend.java01goldensitecontent.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; // JRF manually adding

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
//JRF: keep below OUT when building the autoJoinTbl solution
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="house")
public class HouseMdl {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	// begin: entity-specific table fields
	@NotBlank(message="houseName is required.")
	private String houseName;
    
	private String houseDesc;
	
	private float houseFloat; 
	
	private Integer houseInt; 
	
	private String houseLookup; 

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date houseDate;
    // end: entity-specific table fields
    
    // start: code for joins
    
    // join user 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="createdby_id")
    private UserMdl userMdl;  

	// join twinone
    @OneToMany(mappedBy="houseMdl", fetch = FetchType.LAZY)
    private List<TwinoneMdl> twinoneList; 
	
    // end: code for joins
	
    // instantiate the model: 
    public HouseMdl() {}
    
    // add methods to populate maintain createdAt/UpdatedAt
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
        // begin: getters and setters
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

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseDesc() {
		return houseDesc;
	}

	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc;
	}

	public float getHouseFloat() {
		return houseFloat;
	}

	public void setHouseFloat(float houseFloat) {
		this.houseFloat = houseFloat;
	}

	public Integer getHouseInt() {
		return houseInt;
	}

	public void setHouseInt(Integer houseInt) {
		this.houseInt = houseInt;
	}

	public String getHouseLookup() {
		return houseLookup;
	}

	public void setHouseLookup(String houseLookup) {
		this.houseLookup = houseLookup;
	}

	public Date getHouseDate() {
		return houseDate;
	}

	public void setHouseDate(Date houseDate) {
		this.houseDate = houseDate;
	}

	public List<TwinoneMdl> getTwinoneList() {
		return twinoneList;
	}

	public void setTwinoneList(List<TwinoneMdl> twinoneList) {
		this.twinoneList = twinoneList;
	}

	public UserMdl getUserMdl() {
		return userMdl;
	}

	public void setUserMdl(UserMdl userMdl) {
		this.userMdl = userMdl;
	}



    // end: getters and setters
    
// end mdl
}
