package org.elan.ws.service.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SMSADDetailRequest")
public class SMSADDetailRequest implements Serializable{

	private int id;

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

	private String adCode;

	private String adDetails;

	private String adUser;

	private String adCreatedDate;

	private String adUpdatedDate;

}
