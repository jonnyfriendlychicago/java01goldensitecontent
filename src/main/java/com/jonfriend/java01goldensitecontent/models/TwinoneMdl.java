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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="twinone")
public class TwinoneMdl {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	// begin: entity-specific table fields
	@NotBlank(message="twinoneName is required.")
	private String twinoneName;
    
	private String twinoneDesc;
	
	private float twinoneFloat; 
	
	private Integer twinoneInt; 
	
	private String twinoneLookup; 
	
//	@Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date twinoneDate;
    
    // end: entity-specific table fields
    
    // start: code for joins
    
    // join user table
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="createdby_id")
	private UserMdl userMdl;  
	
	// join house table
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="house_id")
	private HouseMdl houseMdl;
	
    // join onetwinchild table
    @OneToMany(mappedBy="twinoneMdl", fetch = FetchType.LAZY)
    private List<OnetwinchildMdl> onetwinchildList; 
	
    // join twintwo
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "twintwo_twinone", 
    		joinColumns = @JoinColumn(name = "twinone_id"), 
    		inverseJoinColumns = @JoinColumn(name = "twintwo_id")
    		)
    private List<TwintwoMdl> twintwoMdl;
    
	
    // instantiate the model: 
    public TwinoneMdl() {}
    
    // add methods to populate maintain createdAt/UpdatedAt
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    // begin: getters and setters

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

	public String getTwinoneName() {
		return twinoneName;
	}

	public void setTwinoneName(String twinoneName) {
		this.twinoneName = twinoneName;
	}

	public String getTwinoneDesc() {
		return twinoneDesc;
	}

	public void setTwinoneDesc(String twinoneDesc) {
		this.twinoneDesc = twinoneDesc;
	}

	public float getTwinoneFloat() {
		return twinoneFloat;
	}

	public void setTwinoneFloat(float twinoneFloat) {
		this.twinoneFloat = twinoneFloat;
	}

	public Integer getTwinoneInt() {
		return twinoneInt;
	}

	public void setTwinoneInt(Integer twinoneInt) {
		this.twinoneInt = twinoneInt;
	}

	public String getTwinoneLookup() {
		return twinoneLookup;
	}

	public void setTwinoneLookup(String twinoneLookup) {
		this.twinoneLookup = twinoneLookup;
	}

	public Date getTwinoneDate() {
		return twinoneDate;
	}

	public void setTwinoneDate(Date twinoneDate) {
		this.twinoneDate = twinoneDate;
	}

	public List<TwintwoMdl> getTwintwoMdl() {
		return twintwoMdl;
	}

	public void setTwintwoMdl(List<TwintwoMdl> twintwoMdl) {
		this.twintwoMdl = twintwoMdl;
	}

	public UserMdl getUserMdl() {
		return userMdl;
	}

	public void setUserMdl(UserMdl userMdl) {
		this.userMdl = userMdl;
	}

	public HouseMdl getHouseMdl() {
		return houseMdl;
	}

	public void setHouseMdl(HouseMdl houseMdl) {
		this.houseMdl = houseMdl;
	}

	public List<OnetwinchildMdl> getOnetwinchildList() {
		return onetwinchildList;
	}

	public void setOnetwinchildList(List<OnetwinchildMdl> onetwinchildList) {
		this.onetwinchildList = onetwinchildList;
	}

    
    // end: getters and setters
    
// end mdl
}
