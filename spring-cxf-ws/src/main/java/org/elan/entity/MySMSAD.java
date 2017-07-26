package org.elan.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MYSMSAD")

public class MySMSAD implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "AD_CODE")
	private String adCode;
	@Column(name = "AD_DETAILS")
	private String adDetails;
	@Column(name = "AD_USER")
	private String adUser;
	@Column(name = "AD_CREATEDDATE")
	private String adCreatedDate;
	@Column(name = "AD_UPDATEDDATE")
	private String adUpdatedDate;

	public MySMSAD() {

	}

	public MySMSAD(int id, String adCode, String adDetails, String adUser, String adCreatedDate, String adUpdatedDate) {
		super();
		this.id = id;
		this.adCode = adCode;
		this.adDetails = adDetails;
		this.adUser = adUser;
		this.adCreatedDate = adCreatedDate;
		this.adUpdatedDate = adUpdatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public String getAdDetails() {
		return adDetails;
	}

	public void setAdDetails(String adDetails) {
		this.adDetails = adDetails;
	}

	public String getAdUser() {
		return adUser;
	}

	public void setAdUser(String adUser) {
		this.adUser = adUser;
	}

	public String getAdCreatedDate() {
		return adCreatedDate;
	}

	public void setAdCreatedDate(String adCreatedDate) {
		this.adCreatedDate = adCreatedDate;
	}

	public String getAdUpdatedDate() {
		return adUpdatedDate;
	}

	public void setAdUpdatedDate(String adUpdatedDate) {
		this.adUpdatedDate = adUpdatedDate;
	}

}
