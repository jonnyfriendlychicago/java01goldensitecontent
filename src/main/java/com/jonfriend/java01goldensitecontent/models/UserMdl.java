package com.jonfriend.java01goldensitecontent.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class UserMdl {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @NotEmpty(message="Username is required!")
//    @Size(min=3, max=128, message="Username must be between 3 and 30 characters")
    private String userName;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=3, max=128, message="Password must be between 8 and 20 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=3, max=128, message="Confirm Password must match password")
    private String confirm;
    
    private String firstName;
    
    private String lastName;
    
//    private String addressLineOne;
//    
//    private String addressLineTwo;
//    
//    private String city;
//    
//    private String state;
//    
//    private String zipCode;
    
    // jrf new for userAccessLevel
    
//    private Integer userAccessLevel; 

    // join house
    @OneToMany(mappedBy="userMdl", fetch = FetchType.LAZY)
    private List<HouseMdl> houseList; 
    
    // join twinone
    @OneToMany(mappedBy="userMdl", fetch = FetchType.LAZY)
    private List<TwinoneMdl> twinoneList; 
    
    // join twintwo
    @OneToMany(mappedBy="userMdl", fetch = FetchType.LAZY)
    private List<TwintwoMdl> twintwoList;
    
    // join onetwinchild
    @OneToMany(mappedBy="userMdl", fetch = FetchType.LAZY)
    private List<OnetwinchildMdl> onetwinchildList; 
    
    // instantiate the mdl
    public UserMdl() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//
//	public String getAddressLineOne() {
//		return addressLineOne;
//	}
//
//
//	public void setAddressLineOne(String addressLineOne) {
//		this.addressLineOne = addressLineOne;
//	}
//
//
//	public String getAddressLineTwo() {
//		return addressLineTwo;
//	}
//
//
//	public void setAddressLineTwo(String addressLineTwo) {
//		this.addressLineTwo = addressLineTwo;
//	}
//
//
//	public String getCity() {
//		return city;
//	}
//
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//
//	public String getState() {
//		return state;
//	}
//
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//
//	public String getZipCode() {
//		return zipCode;
//	}
//
//
//	public void setZipCode(String zipCode) {
//		this.zipCode = zipCode;
//	}

    // begin G/S - delete then refresh below everytime the userMdl is updated



    // end G/S
  
}

