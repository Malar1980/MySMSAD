
package org.elan.ws.service.to;

import javax.xml.bind.annotation.XmlRootElement;


//@XmlType(namespace="SMSADDetailResponse", name = "SMSADDetailResponse", propOrder = { "Id","AD_code","AD_Details","AD_User","AD_created_Date","AD_Updated_Date" }) 
@XmlRootElement(name = "SMSADDetailResponse")
public class SMSADDetailResponse {
	protected int id;
	protected String adCode;
	protected String adCreatedDate;
	protected String adUpdatedDate;
	protected String adDetails;
	protected String adUser;
	
	
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

	
	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	protected String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	



}
